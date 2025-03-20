// Variables
const a = 5;
const b = 2;
const myName = "haeum";

console.log(a + b);
console.log(a * b);
console.log(a / b);
console.log("hello " + myName);

// const and let
const a2 = 5;
const b2 = 2;
let myName2 = "haeum";

console.log(a2 + b2);
console.log(a2 * b2);
console.log(a2 / b2);
console.log("hello " + myName2);

myName2 = "haeum808";
console.log("your new name is " + myName2);

// Booleans
const amIFat = true;
const amIFat2 = null;
let something; // undefined
console.log(amIFat, amIFat2, something);

// Arrays
const daysOfWeek = ["mon", "tue", "wed", "thu", "fri", "sat"];

console.log(daysOfWeek[4]); // Get Item from Array

console.log(daysOfWeek);
daysOfWeek.push("sun") // Add one more day to the array
console.log(daysOfWeek);

// Objects
const player = {
    name: "haeum",
    points: 10,
    fat: true,
};

console.log(player.name);
console.log(player["name"]);

player.fat = false;
player.lastName = "potato"
player.points = player.points + 15;
console.log(player);
