# Karat pyUSB #

Yedi Karat, bilgisayar ile olan iletişimi, Rs232 protokolünün aksine USB protokolü aracılığı ile gerçekleştirmektedir. [USB\_Deneme](USB_Deneme.md) adı altında verilen örneğin bilgisayar tarafındaki küçük bi script örneği.

## Örnek pyUSB ##

```
import time
from usbdevice import KaratUsbDevice
n = 5	#data sayisi
karat = KaratUsbDevice(idVendor=0x16c0, idProduct=0x05df)
while True:
	data=karat.read()
	print data
	time.sleep(1.0/n)
```

usbdevice kütüphanesi ve örneği,
http://yedikarat.googlecode.com/files/pyUSB.zip adresinden indirilebilir.