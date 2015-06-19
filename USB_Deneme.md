# USB Deneme #

Yedi Karat, bilgisayar ile olan iletişimi, Rs232 protokolünün aksine USB protokolü aracılığı ile gerçekleştirmektedir. Bu nedenle Arduino'nun bilgisayar ile iletişim örneklerinin Yedi Karat'ın üzerinde çalışabilmesi için başka bir donanıma gereksinim duyulmaktadır.

## Örnek USB iletişim kodu ##

```
#include <USB.h>

int potPin=0;

void setup() {
  int i;
    pinMode(13,OUTPUT);
  for (i=0;i<4;i++)
    {
    digitalWrite(13,HIGH);
    delay(50);
    digitalWrite(13,LOW);
    delay(50);
    }
    USB.begin();
    USB.write(0xff);
}

void loop() {
  int pot,data;
  USB.refresh();
  pot=analogRead(potPin);
  USB.write(pot);
  if (USB.available() > 0) {

    data=USB.read();
    if (data==0x11)
    {
      digitalWrite(13,HIGH);
    }
    else if (data==0x22)
    {
      digitalWrite(13,LOW);
    }

/*  if (UsbStream.available() > 0) {
    int pin = UsbStream.read();
    pins[pin] = !pins[pin];
    digitalWrite(pin, pins[pin]);
    UsbStream.write(pin);
    */
  } 
}
```

Yedi Karat'ın programının içerisindeki "USB Monitor" butonundan açılan pencereden veri alışverişi izlenebilir. Ayrıca [pyUSB\_Deneme](pyUSB_Deneme.md) scriptini kullanarak farklı amaçlar için program geliştirilebilir.