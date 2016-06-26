# Register

Run by typing the following in terminal window:

cat <input file> | java -classpath <classpath> com.flitig.Main > <output file>

Takes the contents of a piped textfile on stdin and outputs result on stdout. Program requires well formated input and doesn't handle duplicates. This is according to specification.

Example of input.txt:
```
add check account Bankkonto
add expense account Livsmedel
add expense account Hyra
add income account Inkomst
transaction from:Inkomst   to:Bankkonto 1000
transaction from:Bankkonto to:Livsmedel 50
transaction from:Bankkonto to:Hyra      250
transaction from:Inkomst   to:Bankkonto 1000
transaction from:Bankkonto to:Hyra      250
```
