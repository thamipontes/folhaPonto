# folha-de-ponto


#### GITMOJI

* Para utilizar o gitmoji basta colocar o seguinte comando no seu terminal:
```bash
git commit -am ":nomedoemoji: mensagem" -m "outra mensagem"
```
  ou 
```bash
gitmoji -c 
```

##Como rodar o projeto
Siga a ordem dos passos listados abaixo

#### SONARQUBE e MYSQL

* **Primeiro passo:** instalar o docker-compose.

* **Segundo passo:** Subir o SonarQube e o Mysql com o comando abaixo (precisa do docker em pé para subir o projeto!)
```bash
docker-compose -f sonarqube-mysql.yml up
```

* **Terceiro passo:** Abrir o navegador com a URL localhost:9000

* **Quarto passo:** Para fazer login no SonarQube, existe uma senha e login padrão: admin(login), admin(senha). 

* **Quinto passo:** Suba o projeto no SonarQube usando o comando abaixo
```bash
./gradlew sonarqube
```

* **Sexto passo:** Caso queira parar o serviço no docker do SonarQube e o Mysql (caso queira subir o projeto, não pare o docker)
```bash
docker-compose -f sonarqube-mysql.yml down
```

#### BUILD
* Para fazer o build do projeto e rodar todos os test basta digitar no terminal:
```bash
./gradlew build
```

#### TESTES
* Para rodar os testes separado basta rodar o comando no terminal:
```bash
./gradlew test
```
#### Consertar os warnings do Lint automaticamente (Spotless)
```bash
./gradlew spotlessApply
```

#### Subir o Spring Boot
* Para subir o backend vá até o arquivo FolhaApplication, clique com o botão direito e aperte em:
Run 'FolhaAplication'

ou

* Rode pelo bash o comando:
```bash
./gradlew bootRun
```
