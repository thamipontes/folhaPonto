# folha-de-ponto


#### GITMOJI

* Para utilizar o gitmoji basta colocar o seguinte comando no seu terminal:
```bash
git commit -am ":nomedoemoji: mensagem" -m "outra mensagem"
```

##Como rodar o projeto
Siga a ordem dos passos listados abaixo

#### SONARQUBE e MYSQL

* **Primeiro passo:** instalar o docker-compose.

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

#### Subir o Spring Boot
* Para subir o backend vá até o arquivo FolhaApplication, clique com o botão direito e aperte em:
Run 'FolhaAplication'


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

