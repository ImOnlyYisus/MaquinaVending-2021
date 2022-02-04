**PROYECTO 1º DAW ![](./readme/Aspose.Words.24349f49-a4e1-49de-ab80-ae9e5f12b99a.001.png)**

**MÁQUINAS DE VENDING** 

Una máquina expendedora o máquina de vending es una máquina que proporciona aperitivos, bebidas, golosinas y otros productos a los consumidores. Se trata de vender sin la presencia de un dependiente para cobrar los artículos.

La idea del proyecto es poner en práctica todo lo aprendido en el primer bloque y los conceptos básicos de orientación a objetos, usando como centro de atención la programación de una pequeña máquina expendedora. Evidentemente nuestro “software de última generación” no estará instalado en ningún dispositivo, sino que se ejecutará en nuestro entorno de desarrollo.![](./readme/Aspose.Words.24349f49-a4e1-49de-ab80-ae9e5f12b99a.002.png)

Por simplicidad, nuestra máquina cuenta con los siguientes componentes:

- **Seis bandejas** de alimentación

dispuestas en el compartimento principal para dispensar hasta seis tipos diferentes de productos. Cada bandeja cuenta con una espiral metálica que aloja una pila de artículos. Cada vez que se selecciona un

producto de una bandeja usando el código apropiado, la espiral empuja el producto exterior de la bandeja hacia el compartimento donde el cliente puede recogerlo. De manera opcional, se puede ampliar el número de bandejas usando una estructura

de almacenamiento, hasta un máximo de 20.

- Una **pantalla táctil**, que sirve como panel informativo al usuario o al administrador de la máquina, y a la vez sirve para introducir los códigos de compra de los productos y los comandos de administración.
- Un pequeño **sistema de recolección de dinero**, así como un depósito de devolución de efectivo.
- Un **contenedor** de productos donde el usuario recoge los artículos comprados.
- Todas las máquinas tienen un número de serie único que no cambia(usa la clase *UUID* de la API de Java), un tamaño (número de bandejas) y la dirección donde está ubicada la misma.

La aplicación solicita y muestra todos los datos al usuario que la está manejando usando JOption. Puedes usar la consola para tareas de depuración y pruebas.

La interacción con la máquina se puede dar de dos formas:

- **MODO USUARIO**
- La interacción del usuario con la máquina es muy simple. El cliente proporciona el código del producto que quiere comprar, la máquina informa del precio a través del panel informativo, dando dos opciones de pago: efectivo o tarjeta.
- Si el comprador decide pagar en efectivo, debe proporcionar las monedas suficientes o bien un billete máximo de 20 euros. Si la máquina no puede dar la vuelta al cliente, debe informar de que no tiene cambio y solicitar el importe exacto. En caso de que no se suministre un importe exacto, el producto no cae al contenedor de recogida, quedando cancelada la operación.
- Si el cliente paga con tarjeta de crédito/débito, la transacción debe verificarse por lo que la “pasarela de pago” consulta si la tarjeta es válida. En tal caso, proporciona el producto al usuario. Si la tarjeta no es válida, se informa al usuario, se cancela la operación y se debe comenzar de nuevo el proceso de compra.
- Si la venta se realiza satisfactoriamente, la máquina debe almacenar la venta (dinero recaudado en efectivo / dinero recaudado por tarjeta) y reajustar el stock de las bandejas.
- **MODO ADMIN.**
- El administrador debe teclear un código numérico de 8 dígitos para activar el modo “mantenimiento”. Cada máquina puede tener códigos de administrador diferentes, que se generan aleatoriamente al crear la máquina. El código contendrá, al menos:
  - Una minúscula (a - z)
  - Una mayúscula (A - Z)
  - Un número (0 - 9)
  - Uno de los siguientes caracteres especiales: # $ % &  ( ) \* + , - .  : ; < = > @
- Una vez que el administrador entra en modo mantenimiento, puede:
- Consultar y cambiar el código de las bandejas.
- Consultar y cambiar el producto contenido en las bandejas.
- Consultar y cambiar el stock de las bandejas, usando el código de las mismas. La cantidad máxima de productos por bandeja es de 15.
- Consultar el efectivo que hay en la máquina y recaudar. Se debe guardar la fecha de la recaudación.
- Recargar efectivo, para que la máquina tenga dinero con el que dar las vueltas. Se debe guardar la fecha de la recarga.
- Consultar el dinero recaudado mediante tarjetas de crédito.

**ASPECTOS A TENER EN CUENTA**:

- La “pasarela de pago” con tarjeta, ya que no tenemos bases de datos donde consultar, se implementará mediante tres objetos tarjeta de crédito que cada máquina puede almacenar. Opcionalmente, se puede usar una estructura de almacenamiento para poder guardar tantas tarjetas como queramos.
- De una tarjeta de crédito se guardará el número de tarjeta, la fecha de vencimiento y el CVV.
- El grupo de alumnos/as debe proporcionar una solución eficiente para gestionar el efectivo de la máquina y dar las vueltas necesarias a los compradores.
- Las credenciales se almacenan en la aplicación usando constantes.
- Para gestionar las fechas se usarán objetos LocalDate de la API de Java.

**RECOMENDACIONES**

Como puedes observar, esta aplicación debe resolver múltiples situaciones y llevar el control de muchos casos de uso diferentes. Debes tener en cuenta, para poder realizar realizar un buen proyecto, las siguientes recomendaciones:

- Aplica un **diseño descendente**, aplicando técnicas “**divide y vencerás**”. Ve de lo general a lo específico, dejando los detalles para el final.
- Realiza **algoritmos** para los distintos casos que encuentres.
- **Prueba** tus algoritmos con distintos casos de prueba.
- Una vez probados, debes integrarlos en la aplicación final.
- Utiliza **control de versiones**, de forma que cada pequeño cambio, nuevo método, clase, archivo, etc quede reflejado en Git y GitHub. Hablar con tu compañero/a y notificarle los cambios realizados es fundamental. Es muy importante hacer pull antes de ponerse a trabajar y hacer push de cualquier cambio.
- Ten en cuenta que debes aplicar todo lo aprendido hasta la fecha en el módulo.

