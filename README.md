# springboot-qr-code-generator

# QR Code Generator API

A simple Spring Boot application that generates QR code images from input text. The generated QR codes are returned as PNG images directly via a REST API.

## Features

- Generate QR codes from any text
- Customizable image width and height
- Returns QR code as PNG in response
- Built using Spring Boot and ZXing

## Tech Stack
- Java 17
- Spring Boot
- ZXing (QR Code library)
- Maven

## curl
- curl --location 'http://localhost:8080/api/qr/generate?text=https%3A%2F%2Fstart.spring.io%2F'
Note:
You can replace the text parameter with any string you want to encode, for example:
- curl --location 'http://localhost:8080/api/qr/generate?text=arzooKhatri'

## Refrence link
- https://www.youtube.com/watch?v=-Wabx4zaC40
- https://github.com/codeonedigest/springbootqrcodegenerator
- https://www.baeldung.com/java-generating-barcodes-qr-codes

## for test scanner
- https://scanqr.org/
