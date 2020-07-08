#!/bin/bash
mvn clean package -DskipTests
java -jar ./target/Example.jar