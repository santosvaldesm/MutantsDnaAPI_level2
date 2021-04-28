# limpiar y Compliar el proyecto
mvn clean install -DskipTests							

#Ejecturar test unitarios y verificar la coberura de codigo
#El codigo queda en mutantsDnaAPI\target\site\jacoco\index.html
mvn clean jacoco:prepare-agent install jacoco:report
![N|Solid](https://raw.githubusercontent.com/santosvaldesm/MutantsDnaAPI_level2/blob/master/assets/Captura1.PNG)

#Crear imagen del microservicio	
docker build -t mutants-image .							

#crear un contendor con el microservicio
docker run --name mutants-container -p 8080:8080 -d mutants-image	

#Probar el microservicio 
curl --header "Content-Type: application/json" --request POST --data '{"dna":["CTWCTG","CCGTGC","TGCAGT","TAAAAA","ATTTTT","TCATTC"]}' http://localhost/mutant/