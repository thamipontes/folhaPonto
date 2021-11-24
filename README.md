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

* **Primeiro passo:** instalar o docker-compose. (Caso não tenha interesse em usar o docker, vá para a seção [Banco H2](https://github.com/thamipontes/folhaPonto#banco-h2))

* **Segundo passo:** Subir o SonarQube e o Mysql com o comando abaixo
```bash
docker-compose -f sonarqube-mysql.yml up
```

* **Terceiro passo:** Abrir o navegador com a URL localhost:9000

* **Quarto passo:** Para fazer login no SonarQube, existe uma senha e login padrão: admin(login), admin(senha). 

* **Quinto passo:** Suba o projeto no SonarQube usando o comando abaixo
```bash
./gradlew sonarqube
```


* **Sexto passo:** Caso queira parar o serviço no docker do SonarQube e o Mysql
```bash
docker-compose -f sonarqube-mysql.yml down
```

#### BANCO H2
_Rodando com banco H2 em memória (CASO NÃO QUEIRA USAR O DOCKER)_
 
* **Primeiro passo**: Vá ao arquivo [application.yaml](https://github.com/thamipontes/folhaPonto/blob/main/src/main/resources/application.yaml) 
tire de comentário a parte que fala sobre h2 (apague os # que estão no início de cada linha):

```yaml
  h2:
    console:
      enabled: true
      path: /h2-console
  datasource:
    password: testebanco
    url: jdbc:h2:mem:folhaPonto
    username: sa
    driver-class-name: org.h2.Driver
```

* **Segundo passo**: Agora comente a parte que fala sobre o mysql (coloque # no início de cada linha):

```yaml
#  datasource:
#    password: testebanco
#    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/folhaPonto
#    username: root
#    driver-class-name: com.mysql.cj.jdbc.Driver
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

#### Criar o frontend
* Instalar o node
* Rodar o comando pra criar a aplicação React

```bash
npx create-react-app folha-ponto-frontend
```

#### Rodar o Frontend
```bash
yarn start
```

