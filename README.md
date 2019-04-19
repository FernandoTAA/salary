# salary

A system to calculate net salary according to gross salary and salary deductions.

## How to run

Create the package

```sh
mvn clean package
```

Run application 

```sh
java -jar taget/salary-1.0-SNAPSHOT.jar
```

### Create database

Run class: com.fernandotaa.salary.DataLoader.java (in test scope)

```sh
mvn clean package
java -cp target/salary-1.0-SNAPSHOT.jar com.fernandotaa.salary.DataLoader
```

## Main frame
![Main frame](https://raw.githubusercontent.com/FernandoTAA/salary/master/docs/imgs/frame.png)
