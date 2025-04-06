
// Use version 3.1
#include <DmxSimple.h>

// Use version 0.3.3
#include <Ardwloop.h>

void setup() {
  pinMode(LED_BUILTIN, OUTPUT);

  pinMode(2, OUTPUT);
  digitalWrite(2, HIGH);

  DmxSimple.usePin(4);

  ardw_setup(BAUD_9600);

  int max = ardw_r()->a.x;

  DmxSimple.maxChannel(max);

  for (int i = 1; i <= max; i++) {
    DmxSimple.write(i, 0);
  }

}

void loop() {
  ardw_loop();

  int v = ardw_r()->a.v;
  
  if(v==-1) {
    delay(30);
    return;
  }
 
  int channel = ardw_r()->a.x;
  int value = ardw_r()->a.y;

  DmxSimple.write(channel, value);   // rotation
}
