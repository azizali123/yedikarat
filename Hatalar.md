Karşılaşılabilecek olası hata mesajları ve çözüm yolları,

# Linux için #

## Hata ##

error while loading shared libraries: libreadline.so.5: cannot open shared object file: No such file or directory

## Çözüm ##

_**libreadline5**_ kütüphanesinin yüklenmesi hatayı giderir.

```
sudo apt-get install libreadline5
```

## Hata ##

avrdude: Warning: cannot query manufacturer for device: error sending control message: _Protocol error_
avrude: error: could not find USB device "Karat" with vid=0x16c0 pid=0x5dc

## Çözüm ##

Program yükleme butonuna basmadan önce, Karat'ın üzerinde bulunan Yenile tuşuna basıp, kırmızı LED'in yandığından emin olduktan sonra program yükleme butonunu basılmalıdır.

## Hata ##

avrdude: Warning: cannot query manufacturer for device: error sending control message: _Operation not permitted_
avrude: error: could not find USB device "Karat" with vid=0x16c0 pid=0x5dc

## Çözüm ##


_**/etc/udev/rules/**_

dizini içerisine

_**60-karat.rules**_

isimli bir dosya oluşturup, içerisine aşağıdaki satırlar eklenmelidir.

```
SUBSYSTEM!="usb_device", ACTION!="add", GOTO="karat_rules_end"
# Yedi Karat
SYSFS{idVendor}=="16c0", SYSFS{idProduct}=="05dc", GROUP="users", MODE="666"
LABEL="karat_rules_end"
```