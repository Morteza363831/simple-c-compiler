# Simple C Language Compiler

This project is a **C language compiler** that includes a lexer, parser, semantic analyzer, and TAC (Three Address Code) generator. It was developed by [Morteza Mahdi Zadeh](https://github.com/Morteza363831) and [Soheil Nouhi](https://github.com/SoheilNouhi).

---

## 🚀 **Features**

### **1. Grammar**
The compiler uses **ANTLR** to define the grammar for the C language. The grammar supports the following features:
- **Function Declarations**: `int main() { ... }`
- **Statements**:
  - Expression statements (`x = 10;`)
  - Return statements (`return x;`)
  - Blocks (`{ ... }`)
  - Printf statements (`printf("value is %d", x);`)
  - Control structures:
    - **If-Else Statements** (`if (x < 10) { ... } else { ... }`)
    - **While Loops** (`while (x > 0) { ... }`)
    - **For Loops** (`for (int i = 0; i < 10; i++) { ... }`)
- **Variable Declarations and Assignments**:
  - Supported types: `int`, `float`, `char`, `void`
  - Example: `int x = 10;`
- **Expressions**:
  - Arithmetic operations (`+`, `-`, `*`, `/`, `^`)
  - Comparison operators (`<`, `>`, `<=`, `>=`, `==`, `!=`)
  - String, character, and numeric constants.

---

## 📂 **Project Structure**
The project is organized into the following packages:
- **`org.compiler.antlr`**: Contains the `CLang.g4` grammar file.
- **`org.compiler.lexer`**: Contains the `CLangLexer` for tokenizing the source code.
- **`org.compiler.parser`**: Includes:
  - `CLangParser` for parsing the tokens.
  - `CLangBaseListener` and `CLangBaseVisitor` interfaces and their implementations.
- **`org.compiler.semantic`**: Contains the `SemanticAnalyzer` for scope and type checking.
- **`org.compiler.tac`**: Contains:
  - `TacGenerator` for generating three-address code.
  - `TacInstruction` for representing TAC instructions.

---

## 🛠️ **Running the Compiler**

### **Clone the Repository**
```bash
git clone https://github.com/Morteza363831/compiler.git
cd compiler
```
### **Run the Main Program**
```bash
mvn exec:java -Dexec.mainClass="org.compiler.Main"
```
### **Build the Project**
```bash
mvn clean package
```
### **Run Using the Jar File**

A precompiled **JAR** file is available in the **Releases** section.
To run it :
```bash
java -jar compiler-1.0.jar
```
## 🤝 **Contributors**
Thanks to the following **developers** for their contributions:
- [Morteza Mahdi Zadeh](https://github.com/Morteza363831)
- [Soheil Nouhi](https://github.com/moonwinee)


### **Notes:**
- I added sections for features, contributors, and instructions for running the project.
- If there's any additional information you'd like, let me know!
#### **Contact with us**
- Morteza Mahdi Zadeh's email : [morteza363831official@gmail.com](morteza363831official@gmail.com)
- Soheil Nouhi's email : [soheilnohi83@gmail.com](soheilnohi83@gmail.com)
