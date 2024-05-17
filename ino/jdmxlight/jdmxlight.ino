
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

  int x = ardw_r()->a.x;
  int y = ardw_r()->a.y;
  int z = ardw_r()->a.z;

  DmxSimple.write(1, x);   // rotation
  DmxSimple.write(2, y);   // inclinaison
  DmxSimple.write(6, z);   // couleur
  DmxSimple.write(7, 255);  // fréquence d'obturateur
  DmxSimple.write(8, 30);   // gradateur
  DmxSimple.write(9, 31);   // gobos
}
