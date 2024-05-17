
#include <DmxSimple.h>
#include <Ardwloop.h>

void setup() {
  pinMode(LED_BUILTIN, OUTPUT);

  pinMode(2, OUTPUT);
  digitalWrite(2, HIGH);

  DmxSimple.usePin(4);
  DmxSimple.maxChannel(14);

  for (int i = 1; i <= 14; i++) {
    DmxSimple.write(i, 0);
  }

  ardw_setup();
}

void loop() {
  ardw_loop();

  DmxSimple.write(1, 27);   // rotation
  DmxSimple.write(2, 45);   // inclinaison
  DmxSimple.write(6, 99);   // couleur
  DmxSimple.write(7, 255);  // fréquence d'obturateur
  DmxSimple.write(8, 30);   // gradateur
  DmxSimple.write(9, 31);   // gobos
}
