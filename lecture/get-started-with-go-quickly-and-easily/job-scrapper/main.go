package main

import (
	"encoding/csv"
	"fmt"
	"github.com/PuerkitoBio/goquery"
	"log"
	"net/http"
	"os"
	"strconv"
	"strings"
)

type extractedJob struct {
	id           string
	title        string
	jobDate      string
	jobCondition string
	jobSector    string
}

var baseURL = "https://www.saramin.co.kr/zf_user/search/recruit?&searchword=python"

func main() {
	var jobs []extractedJob
	channel := make(chan []extractedJob)
	totalPages := getPages()

	for i := 0; i < totalPages; i++ {
		go getPage(i, channel)
	}

	for i := 0; i < totalPages; i++ {
		extractedJobs := <-channel
		jobs = append(jobs, extractedJobs...)
	}

	writeJobs(jobs)
	fmt.Println("Done, extracted", len(jobs))
}

func getPage(page int, mainChannel chan<- []extractedJob) {
	var jobs []extractedJob
	channel := make(chan extractedJob)
	pageURL := baseURL + "&recruitPage=" + strconv.Itoa(page+1)
	fmt.Println("Requesting", pageURL)
	res, err := http.Get(pageURL)
	checkErr(err)
	checkCode(res)

	defer res.Body.Close()

	doc, err := goquery.NewDocumentFromReader(res.Body)
	checkErr(err)

	searchCards := doc.Find(".item_recruit")

	searchCards.Each(func(i int, card *goquery.Selection) {
		go extractJob(card, channel)
	})

	for i := 0; i < searchCards.Length(); i++ {
		job := <-channel
		jobs = append(jobs, job)
	}

	mainChannel <- jobs
}

func writeJobs(jobs []extractedJob) {
	file, err := os.Create("jobs.csv")
	checkErr(err)

	w := csv.NewWriter(file)
	defer w.Flush()

	headers := []string{"ID", "title", "jobDate", "jobCondition", "jobSector"}

	wErr := w.Write(headers)
	checkErr(wErr)

	for _, job := range jobs {
		jobSlice := []string{"https://www.saramin.co.kr/zf_user/jobs/relay/view?isMypage=no&rec_idx=" + job.id, job.title, job.jobDate, job.jobCondition, job.jobSector}
		jwErr := w.Write(jobSlice)
		checkErr(jwErr)
	}
}

func extractJob(card *goquery.Selection, channel chan<- extractedJob) {
	id, _ := card.Attr("value")
	title := cleanString(card.Find(".area_job>h2").Text())
	jobDate := cleanString(card.Find(".job_date").Text())
	jobCondition := cleanString(card.Find(".job_condition").Text())
	jobSector := cleanString(card.Find(".job_sector").Text())
	channel <- extractedJob{
		id:           id,
		title:        title,
		jobDate:      jobDate,
		jobCondition: jobCondition,
		jobSector:    jobSector,
	}
}

func cleanString(str string) string {
	return strings.Join(strings.Fields(strings.TrimSpace(str)), " ")
}

func getPages() int {
	pages := 0
	res, err := http.Get(baseURL)
	checkErr(err)
	checkCode(res)

	defer res.Body.Close()

	doc, err := goquery.NewDocumentFromReader(res.Body)
	checkErr(err)

	doc.Find(".pagination").Each(func(i int, s *goquery.Selection) {
		pages = s.Find("a").Length()
	})

	return pages
}

func checkErr(err error) {
	if err != nil {
		log.Fatalln(err)
	}
}

func checkCode(res *http.Response) {
	if res.StatusCode != 200 {
		log.Fatalln("Request failed with Status: ", res.StatusCode)
	}
}
