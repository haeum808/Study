## 티켓 판매 애플리케이션 구현하기

연극이나 음악회를 공연할 수 있는 작은 소극장을 경영하고 있다고 상상해보자.  
이벤트에 당첨된 관람객은 초대장을 티켓으로 교환한 후에 입장할 수 있다. 이벤트에 당첨되지 않은 관람객은 티켓을 구매해야만 입장할 수 있다.

<br>

이벤트 당첨자에게 발송되는 초대방 구현
```kotlin
import java.time.LocalDateTime

class Invitation(private val `when`: LocalDateTime)
```

<br>

공연을 관람하기 원하는 모든 사람들은 티켓을 소지하고 있어야 한다.
```kotlin
class Ticket(private val fee: Long) {
    fun getFee(): Long {
        return fee
    }
}
```

<br>

관람객이 가지고 올 수 있는 소지품은 초대장, 현금, 티켓 세 가지뿐이다.

```kotlin
class Bag(
    private var amount: Long,
    private val invitation: Invitation? = null,
    private var ticket: Ticket? = null,
) {
    fun hasInvitation(): Boolean {
        return invitation != null
    }

    fun hasTicket(): Boolean {
        return ticket != null
    }

    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
```

<br>

관람객이라는 개념을 구현하는 Audience
```kotlin
class Audience(
    private val bag: Bag,
) {
    fun getBag(): Bag {
        return bag
    }
}
```

<br>

매표소에는 관람객에게 판매할 티켓과 티켓의 판매 금액이 보관돼 있어야 한다.
```kotlin
class TicketOffice(
    private var amount: Long,
    private val tickets: MutableList<Ticket> = mutableListOf()
) {
    fun getTicket(): Ticket {
        return tickets.removeFirst()
    }
    
    fun minusAmount(amount: Long) {
        this.amount -= amount
    }
    
    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
```

<br>

판매원은 매표소에서 초대장을 티켓으로 교환해 주거나 티켓을 판매하는 역할을 수행한다.
```kotlin
class TicketSeller(
    private val ticketOffice: TicketOffice,
) {
    fun getTicketOffice(): TicketOffice {
        return ticketOffice
    }
}
```

<br>

![image](https://github.com/user-attachments/assets/0b2e993d-8fc8-4468-9aff-49422bcb11ed)

이제 클래스들을 조합해서 관람객을 소극장에 입장시키는 로직을 완성하는 일만 남았다.

<br>

다음은 소극장을 구현하는 클래스는 Theater다.
```kotlin
class Theater(
    private val ticketSeller: TicketSeller,
) {
    fun enter(audience: Audience) {
        if (audience.getBag().hasInvitation()) {
            val ticket: Ticket = ticketSeller.getTicketOffice().getTicket()
            audience.getBag().setTicket(ticket)
        } else {
            val ticket: Ticket = ticketSeller.getTicketOffice().getTicket()
            audience.getBag().minusAmount(ticket.getFee())
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee())
            audience.getBag().setTicket(ticket)
        }
    }
}
```

작성된 프로그램의 로직은 간단하고 예상대로 동작한다. 하지만 몇 가지 문제점을 가지고 있다.

## 무엇이 문제인가

로버트 마틴은 소프트웨어 모듈이 가져야 하는 세 가지 기능에 관해 설명한다.
1. 실행 중에 제대로 동작하는 것
2. 변경을 위해 존재하는 것
3. 코드를 읽는 사람과 의사소통하는 것

현재 코드는 변경 용이성과 읽는 사람과의 의사소통이라는 목적은 만족시키지 못한다.

### 예상을 빗나가는 코드

enter 메서드가 수행하는 일을 말로 풀어보자.
```
소극장은 관람객의 가방을 열어 그 안에 초대장이 들어 있는지 살펴본다.
가방 안에 초대장이 들어 있으면 판매원은 매표소에 보관돼 있는 티켓을 관람객의 가방 안으로 옮긴다.
가방 안에 초대장이 들어 있지 않다면 관람객의 가방에서 티켓 금액만큼의 현금을 꺼내 매표소에 적립한 후에 매표소에 보관돼 있는 티켓을 관람객의 가방 안으로 옮긴다.
```

현재 문제는 관람객과 판매원이 소극장의 통제를 받는 수동적인 존재라는 점이다.

이해 가능한 코드란 그 동작인 우리의 예상에서 크게 벗어나지 않는 코드다.  
현실에서는 관람객이 직접 자신의 가방에서 초대장을 꺼내 판매원에게 건넨다. 티켓을 구매하는 관람객은 가방 안에서 돈을 직접 꺼내 판매원에게 지불한다. 등등  

하지만 코드 안의 관람객, 판매원은 그렇게 하지 않는다. 현재의 코드는 우리의 상식과는 너무나도 다르게 동작하기 때문에 코드를 읽는 사람과 제대로 의사소통하지 못한다.  

<br>

코드를 이해하기 어렵게 만드는 또 다른 이유가 있다. enter() 메서드를 이해하기 위해서는 여러 가지 세부적인 내용들을 한꺼번에 기억하고 있어야 한다는 점이다.  

Theater의 enter 메서드를 이해하기 위해서는 Audience가 Bag을 가지고 있고, Bag 안에는 현금과 티켓이 들어 있으며 TicketSeller가 TicketOffice에서 티켓을 판매하고, 
TicketOffice안에 돈과 티켓이 보관돼 있다는 모든 사실을 동시에 기억하고 있어야 한다.

### 변경에 취약한 코드

더 큰 문제는 변경에 취약하다는 것이다. 가정이 깨지는 순간 모든 코드가 일시에 흔들리게 된다.  

관람객이 가방을 들고 있다는 가정이 바뀌었다고 해보자.  
세부적인 사실 중 한 가지라도 바뀌면 해당 클래스뿐만 아니라 이 클래스에 의존하는 Theater도 변경해야 한다.  
이처럼 다른 클래스가 Audience의 내부에 대해 더 많이 알면 알수록 Audience를 변경하기 어려워진다.  

이것은 객체 사이의 의존성과 관련된 문제다. 의존성이라는 말 속에는 어떤 객체가 변경될 때 그 객체에 의존하는 다른 객체도 함께 변경될 수 있다는 사실이 내포돼 있다.  

따라서 우리의 목표는 애플리케이션의 기능을 구현하는 데 필요한 최소한의 의존성만 유지하고 불필요한 의존성을 제거하는 것이다.

## 설계 개선하기

해결 방법은 간단하다. Theater가 Audience와 TicketSeller에 관해 너무 세세한 부분까지 알지 못하도록 정보를 차단하면 된다.  
Theater가 원하는 것은 관람객이 소극장에 입장하는 것뿐이다. 관람객과 판매원을 자율적인 존재로 만들면 되는 것이다.

### 자율성을 높이자

첫 번째 단계는 Theater의 enter 메서드에서 TicketOffice에 접근하는 모든 코드를 TicketSeller 내부로 숨기는 것이다.

```kotlin
class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        if (audience.getBag().hasInvitation()) {
            val ticket: Ticket = ticketOffice.getTicket()
            audience.getBag().setTicket(ticket)
        } else {
            val ticket: Ticket = ticketOffice.getTicket()
            audience.getBag().minusAmount(ticket.getFee())
            ticketOffice.plusAmount(ticket.getFee())
            audience.getBag().setTicket(ticket)
        }
    }
}
```

ticketOffice에 대한 접근은 오직 TicketSeller 안에만 존개하게 된다.  
이처럼 개념적이나 물리적으로 객체 내부의 세부적인 사항을 감추는 것을 캡슐화라고 부른다.

<br>

Theater의 enter 메서드는 sellTo 메서드를 호출하는 간단한 코드로 바뀐다.

```kotlin
class Theater(
    private val ticketSeller: TicketSeller,
) {
    fun enter(audience: Audience) {
        ticketSeller.sellTo(audience)
    }
}
```

Theater는 오직 TicketSeller의 인터페이스에만 의존한다. TicketSeller가 내부에 TicketOffice 인스턴스를 포함하고 있다는 사실은 구현의 영역에 속한다.  
객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개하는 것은 객체 사이의 결합도를 낮추고 변경하기 쉬운 코드를 작성하기 위해 따라야 하는 가장 기본적인 설계 원칙이다.

<br>

TicketSeller 다음으로 Audience의 캡슐화를 개선하자. Audience는 여전히 자율적인 존재가 아닌 것이다.

```kotlin
class Audience(
    private val bag: Bag,
) {
    fun buy(ticket: Ticket): Long {
        return if (bag.hasInvitation()) {
            bag.setTicket(ticket)
            0L
        } else {
            bag.minusAmount(ticket.getFee())
            bag.setTicket(ticket)
            ticket.getFee()
        }
    }
}
```

변경된 코드에서 Audience는 자신의 가방 안에 초대장이 들어있는지를 스스로 확인한다.

<br>

이제 TicketSeller가 Audience의 인터페이스에만 의존하도록 수정한다.

```kotlin
class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()))
    }
}
```

### 무엇이 개선됐는가

Audience와 TicketSeller는 자신이 가지고 있는 소지품을 스스로 관리한다. 우리의 예상과도 정확하게 일치한다.  
더 중요한 점은 Audience나 TicketSeller의 내부 구현을 변경하더라도 Theater를 함께 변경할 필요가 없어졌다. 따라서 수정된 코드는 변경 용이성의 측면에서도 확실해 개선됐다.

### 어떻게 한 것인가

자기 자신의 문제를 스스로 해결하도록 코드를 변경했다. 우리는 우리의 직관을 따랐고 그 결과로 코드는 변경이 용이하고 이해 가능하도록 수정됐다.  
객체의 자율성을 높이는 방향으로 설계를 개선했다. 그 결과, 이해하기 쉽고 유연한 설계를 얻을 수 있었다.

### 캡슐화와 응집도

핵심은 객체 내부의 상태를 캡슐화하고 객체 간에 오직 메시지를 통해서만 상호작용하도록 만드는 것이다.  
밀접하게 연관된 작업만을 수행하고 연관성 없는 작업은 다른 객체에게 위임하는 객체를 가리켜 응집도가 높다고 말한다.  
자신의 데이터를 스스로 처리하는 자율적인 객체를 만들면 결합도를 낮출 수 있을뿐더러 응집도를 높일 수 있다.  

객체의 응집도를 높이기 위해서는 객체 스스로 자신의 데이터를 책임져야 한다.  
외부의 간섭을 최대한 배제하고 메시지를 통해서만 협력하는 자율적인 객체들의 공동체를 만드는 것이 훌륭한 객체지향 설계를 얻을 수 있는 지름길이다.

### 절차지향과 객체지향

수정하기 전 Theater의 enter 메서드는 프로세스이며, Audience, TicketSeller, Bag, TicketOffice는 데이터다. 이처럼 프로세스와 데이터를 별도의 모듈에 위치시키는 방식을 절차적 프로그래밍이라고 부른다.  

수정한 후의 코드에서는 데이터를 사용하는 프로세스가 데이터를 소유하고 있는 Audience와 TicketSeller 내부로 옮겨졌다. 데이터와 프로세스가 동일한 모듈 내부에 위치하도록 프로그래밍하는 방식을 객체지향 프로그래밍이라고 부른다.  

훌륭한 객체지향 설계의 핵심은 캡슐화를 이용해 의존성을 적절히 관리함으로써 객체 사이의 결합도를 낮추는 것이다.

### 책임의 이동

근본적인 차이를 만다는 것은 책임의 이동이다.  
수정하기 전 코드는 Theater에 책임이 집중돼 있다.  
수정후 코드는 하나의 기능을 완성하는 데 필요한 책임이 여러 객체에 걸쳐 분산돼 있다.  

객체지향 설계에서는 독재자가 존재하지 않고 각 객체에 책임이 적절하게 분배된다. 따라서 각 객체는 자신을 스스로 책임진다.  

객체지향 설계의 핵심은 적절한 객체에 적절한 책임을 할당하는 것이다. 따라서 객체가 어떤 데이터를 가지느냐보다는 객체에 어떤 책임을 할당할 것이냐에 초점을 맞춰야 한다.  

불필요한 세부사항을 캡슐화하는 자율적인 객체들이 낮은 결합도와 높은 응집도를 가지고 협력하도록 최소한의 의존성만을 남기는 것이 훌륭한 객체지향 설계다.

### 더 개선할 수 있다

Audience는 자율적인 존재다.  
하지만 Bag은 자기 자신을 책임지지 않고 수동적이다.  
Bag의 내부 상태에 접근하는 모든 로직을 Bag 안으로 캡슐화해서 결합도를 낮춘다.

```kotlin
class Bag(
    private var amount: Long,
    private val invitation: Invitation? = null,
    private var ticket: Ticket? = null,
) {
    fun hold(ticket: Ticket): Long {
        return if (hasInvitation()) {
            setTicket(ticket)
            0L
        } else {
            setTicket(ticket)
            minusAmount(ticket.getFee())
            ticket.getFee()
        }
    }
    
    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    private fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}
```

public 이였던 메서드들이 private가 됐다.

<br>

Audience를 Bag의 구현이 아닌 인터페이스에만 의존하도록 수정한다.

```kotlin
class Audience(
    private val bag: Bag,
) {
    fun buy(ticket: Ticket): Long {
        return bag.hold(ticket)
    }
}
```

<br>

TicketSeller 역시 TicketOffice의 자율권을 침해한다.  
TicketOffice에 sellTicketTo 메서드를 추가하고 TicketSeller의 sellTo 메서드의 내부 코드를 이 메서드로 옮긴다.

```kotlin
class TicketOffice(
    private var amount: Long,
    private val tickets: MutableList<Ticket> = mutableListOf()
) {
    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }
    
    private fun getTicket(): Ticket {
        return tickets.removeFirst()
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
```

<br>

TicketSeller는 TicketOffice의 sellTicketTo 메서드를 호출함으로써 원하는 목적을 달성할 수 있다.

```kotlin
class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        ticketOffice.sellTicketTo(audience)
    }
}
```

<br>

그러나 TicketOffice의 자율성은 높였지만 전체 설계의 관점에서는 결합도가 상승했다.  

여기서 두 가지 사실을 알 수 있다.  
1. 어떤 기능을 설계하는 방법은 한 가지 이상일 수 있다.
2. 동일한 기능을 한 가지 이상의 방법으로 설계할 수 있기 때문에 결국 설계는 트레이드오프의 산물이다.

### 그래, 거짓말이다!

비록 현실에서는 수동적인 존재라고 하더라도 일단 객체지향의 세계에 들어오면 모든 것이 능동적이고 자율적인 존재로 바뀐다.  

훌륭한 객체지향 설꼐란 소프트웨어를 구성하는 모든 객체들이 자율적으로 행동하는 설계를 가리킨다.  
그 대상이 비록 실세계에서는 생명이 없는 수동적인 존재라고 하더라도 객체지향의 세계로 넘어오는 순간 그들은 생명과 지능을 가진 싱싱한 존재로 다시 태어난다.

## 객체지향 설계

### 설계가 왜 필요한가

설계의 정의: 코드를 배치하는 것  

좋은 설계란 오늘 요구하는 기능을 온전히 수행하면서 내일의 변경을 매끄럽게 수용할 수 있는 설계다.  

변경을 수용할 수 있는 설계가 중요한 이유는 요구사항이 항상 변경되기 때문이다.  
그리고 변경을 수용할 수 있는 설계가 중요한 또 다른 이유는 코드를 변경할 때 버그가 추가될 가능성이 높기 때문이다.

### 객체지향 설계

객체지향 프로그래밍은 의존성을 효율적으로 통제할 수 있는 다양한 방법을 제공함으로써 요구사항 변경에 좀 더 수월하게 대응할 수 있는 가능성을 높여준다.  

변경 가능한 코드란 이해하기 쉬운 코드다.  
객체지향 패러타다임은 세상을 바라보는 방식대로 코드를 작성할 수 있게 해준다.  
객체지향은 세상에 대해 예상하는 방식대로 객체가 행동하리라는 것을 보장함으로써 코드를 좀 더 쉽게 이해할 수 있게 한다.  

애플리케이션의 기능을 구현하기 위해 객체들이 협력하는 과정 속에서 객체들은 다른 객체에 의존하게 된다.  
메시지를 전송하기 위한 이런 지식이 두 객체를 결합시키고 이 결합이 객체 사이의 의존성을 만든다.  

훌륭한 객체지향 설계란 협력하는 객체 사이의 의존성을 적절하게 관리하는 설계다.  
진정한 객체지향 설계로 나아가는 것은 협력하는 객체들 사이의 의존성을 적절하게 조절함으로써 변경에 용이한 설계를 만드는 것이다.
