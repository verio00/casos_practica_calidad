


Reflexión escrita sobre:

Realizar este proyecto fue una experiencia que me permitió entender mucho más a fondo la importancia de las pruebas unitarias
y de mantener una cobertura alta. Desde el inicio, una de las mayores dificultades fue interpretar correctamente los reportes
de JaCoCo, porque yo pensaba que con ver una línea en verde ya estaba cubierta, pero luego entendí que también existen las 
ramas, y que muchas veces el código usa operadores lógicos como || que generan comportamientos de corto circuito, haciendo
que algunas condiciones nunca se ejecuten si no se diseñan bien los tests.

Esto me obligó a aprender la diferencia entre cobertura de líneas y cobertura de ramas, algo que no dominaba al principio.
Otra dificultad técnica fue la configuración del pipeline en GitHub Actions; al inicio fallaba por diferencias entre la versión de
Java de mi computadora y la que estaba configurada en el workflow, y tuve que probar varias veces hasta que funcionó. A pesar de esos
retos, llegar al 98% de cobertura me permitió entender que una cobertura baja es un riesgo grande, porque significa que hay validaciones,
excepciones y caminos del código que nunca se prueban, lo cual puede causar errores ocultos. Por ejemplo, en la parte de contraseñas, si no
se prueban longitudes extremas o caracteres no permitidos, el sistema podría aceptar claves débiles sin que lo notemos.

Además, una baja cobertura genera una falsa sensación de seguridad: el código funciona, compila y parece estable, pero cualquier cambio pequeño puede
romper algo que no fue probado y recién aparecería el error en producción, lo que es más caro y afecta al usuario final. Finalmente, trabajar con CI/CD
fue uno de los mayores aprendizajes del proyecto. Con GitHub Actions, el pipeline ejecuta las pruebas automáticamente con cada git push y genera el reporte
de JaCoCo, lo que evita confiar en que uno “se acuerde” de ejecutar los tests y elimina el clásico “en mi máquina sí funcionaba”.También es útil poder ver
el historial de ejecuciones y comparar cómo mejoró la cobertura con cada cambio. Este flujo automatizado me ayuda a trabajar de manera más profesional y me
deja claro que CI/CD no solo mejora la calidad del software, sino que también hace todo el proceso más ordenado, repetible y confiable.
