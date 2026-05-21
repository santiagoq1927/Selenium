# Prueba tecnica de Automatización en SauceDemo (Selenium + Cucumber + Java)

# 1 Clonar el repositorio
git clone
# 2 Dar permisos de ejecucion en git bash a la suite (runSuite.sh) que esta en la raiz del proyecto
chmod +x runSuite.sh
# 3 Dar permisos para abrir el reporte en git bash openReport.sh que esta en la raiz del proyecto
chmod +x openReport.sh
# 4 Validar en el archivo runSuite que se encuentre en el grupo regression, aqui este el E2E
./mvnw clean test -Dgroups="regression"
# 5 Ejecutar los test de regression
./runSuite.sh
# 5.1 Ejecutar desde FlowE2E.feature
abrir la feature FlowE2E.feature y seleccionar el icono de play
# 6 Abrir reporte
./openReport.sh
# 6.1 Abrir reporte desde la ruta
buscar el reporte en la siguiente ruta y abrirlo por un navegador: target/cucumber-html-reports/overview-features.html
# 7 Validar en el archivo runSuite que se encuentre en el grupo smoke, aqui estan los casos alternos
./mvnw clean test -Dgroups="smoke"
# 8 Ejecutar los test de regression
./runSuite.sh
# 9 Abrir reporte
./openReport.sh
