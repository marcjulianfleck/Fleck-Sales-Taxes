# SALES TAXES SOLUTION FLECK

## Table of Contents
1. [The Problem](#the-problem)
2. [Assumptions](#assumptions)
3. [Technical Overview](#technical-overview)
4. [Installation & Run Instructions](#installation--run-instructions)

### The Problem
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax
applicable on all imported goods at a rate of 5%, with no exemptions. When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items,
and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping baskets...

| Input 1                   | Expected Output 1        |
|:--------------------------|:-------------------------|
| > 1 book at 12.49         | > 1 book: 12.49          |
| > 1 music CD at 14.99     | > 1 music CD: 16.49      |
| > 1 chocolate bar at 0.85 | > 1 chocolate bar: 0.85  |
|                           | > Sales Taxes: 1.50      |
|                           | > Total: 29.83           |

| Input 2                                 | Expected Output 2                      |
|:----------------------------------------|:---------------------------------------|
| > 1 imported box of chocolates at 10.00 | > 1 imported box of chocolates: 10.50  |
| > 1 imported bottle of perfume at 47.50 | > 1 imported bottle of perfume: 54.65  |
|                                         | > Sales Taxes: 7.65                    |
|                                         | > Total: 65.15                         |

| Input 3                                 | Expected Output 3                      |
|:----------------------------------------|:---------------------------------------|
| > 1 imported bottle of perfume at 27.99 | > 1 imported bottle of perfume: 32.19  |
| > 1 bottle of perfume at 18.99          | > 1 bottle of perfume: 20.89           |
| > 1 packet of headache pills at 9.75    | > 1 packet of headache pills: 9.75     |
| > 1 box of imported chocolates at 11.25 | > 1 imported box of chocolates: 11.85  |
|                                         | > Sales Taxes: 6.70                    |
|                                         | > Total: 74.68                         |

### Assumptions
Before approaching the problem I made the following assumptions:
* The application should be written in Java and be runnable with a JAR-Archive.
* The input data (baskets) is available as formatted txt files as i.e. done in [`assets/input1.txt`](https://github.com/marcjulianfleck/Fleck-Sales-Taxes/blob/master/assets/input1.txt), and must be provided as arguments (paths) to the JAR.
* The mentioned price in the input files are the net price.
* If the quantity is higher than one, the provided price still indicates the net price of only one product.
* Imported products have the word "imported" somewhere inside the item description.
* If no  txt file path is provided to the application (JAR), it will fall back to the three default input files in [`assets/`](https://github.com/marcjulianfleck/Fleck-Sales-Taxes/tree/master/assets).
* The output (receipts) of the applications should get printed inside the console. No GUI is implemented.
* If wrong formatted file paths are provided, a hint is printed to the console as well as if not file can be found on the provided path.

I used txt files, since I was assuming they are required. 
However, I definitely would work with JSON files in any other project since a lot of errors from the Regex-Parsing can be avoided.

### Technical Overview
* Java (OpenJDK 17.0.2)
* Maven v3.8.1
* JUnit v4.13.1
* IntelliJ IDEA 2021.3.2 (Ultimate Edition)
* SourceTree v4.1.5

### Installation & Run Instructions
```
$ git clone https://github.com/marcjulianfleck/Fleck-Sales-Taxes.git
$ cd Fleck-Sales-Taxes/
```
To run with the default input txt files inside [`asstes/`](https://github.com/marcjulianfleck/Fleck-Sales-Taxes/tree/master/assets) just run:
```
$ java -jar SalesTaxes.jar
```
To run it with own input files
```
$ java -jar SalesTaxes.jar path_to_own_input_txt_file-1 path_to_own_input_txt_file-2 ...
```

Of course the project also can be opened in an IDE like IntelliJ IDEA and executed there.

### Tests
The whole implementation process was test driven with JUnit (v4.13.1).
The JUnit tests can be found in [`src/test/java/org/fleck/models`](https://github.com/marcjulianfleck/Fleck-Sales-Taxes/tree/master/src/test/java/org/fleck/models).

Test results can be seen in the following figure.

![Test results Fleck Sales Taxes](https://github.com/marcjulianfleck/Fleck-Sales-Taxes/blob/master/testResults.png?raw=true)

To run the test by yourself open the project with an IDE and run it there with the appropriate configurations. 