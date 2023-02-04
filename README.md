# SE_ScientificCalculator

Repository for the Software Engineering Project, a.a.2021/2022

Project Goal:

Develop an application implementing a scientific programmable calculator supporting complex numbers.

User Epics Implemented:

1. The operation of the calculator revolves around a stack data structure.
The stack contains complex numbers (of course real numbers are
supported as a special case of complex numbers). The user can either
input a number (using the Cartesian notation, e.g. "7.2+4.9j"; the
imaginary part can be omitted, writing "42" instead of "42+0j"), that is
pushed onto the stack, or the name of an operation, that is executed
taking its operands from the stack and pushing its result onto the stack.
The user interface should show the top locations of the stack (at least 12
elements) and should have a text area for entering the user input. The
calculator should support at least the following operations: "+"
(addition), "-" (subtraction), "*" (multiplication), "/" (division), "sqrt"
(square root), "+-" (invert sign). 
For instance, if the user enters the numbers "5" and "9" and then the
operations "-" and "sqrt", the stack will contain just the number "0+2j"
("-" takes "5" and "9" from the stack and pushes their difference "-4",
then "sqrt" takes "-4" from the stack and pushes its square root "0+2j").

2. The calculator includes the following operations for manipulating the
stack: "clear" that removes all the elements; "drop" that removes the
last element (i.e. the top); "dup" that pushes a copy of the last element;
"swap" that exchanges the last two elements; "over" that pushes a copy
of the second last element.

3. The calculator supports 26 variables, named with the letters from "a" to
"z". For each variable "x", the operation ">x" takes the top element from
the stack and saves it into the variable "x". The operation "<x" pushes
the value of the variable "x" onto the stack. The operation "+x" takes the
top element from the stack and adds it to the value of the variable "x"
(storing the result of the addition into "x"). The operation "-x" takes the
top element from the stack and subtracts it from the value of the
variable "x" (storing the result of the subtraction into "x").

4. The user can define a new operation by specifying a name and a
sequence of operations (including the push of numbers). When the userdefined operation is invoked, all the operations in the sequence are
executed in order. The definition of a user-defined operation may contain
other user-defined operations. The user can delete a user-defined
operation. The user can modify the definition of a user-defined operation.
The user can save to a file the existing user-defined operations, and
reload them from a file, even in a different usage session.

5. The calculator includes the following operations that operate on the variables:
"save", which saves a copy of all the 26 variables on a "variable stack"
(distinct from the stack used for the operands by the operations); "restore",
which restores for all variables the last values that were saved on the
"variable stack" (removing them from that stack). It is possible to perform
several times the "save" operation, preserving several sets of variable values.
This mechanism can be used to temporarily modify a variable within a userdefined operation, without making this modification visible outside of the
execution of the user-defined operation.

6. The calculator includes the following operations, taking complex numbers
as operands (from the stack) and producing (possibly) complex results
(pushed onto the stack): "mod" (modulus/magnitude); "arg"
(argument/phase); "pow" (power); "exp" (exponential); "log" (natural
logarithm); "sin" (sine); "cos" (cosine); "tan" (tangent); "asin" (arc
sine); "acos" (arc cosine); "atan" (arc tangent).
_________________________________________________________________________________________________________________________________________________________________________
Description of Software Architecture: https://docs.google.com/document/d/1KZLgk1bGAFtU3AWhULjgCDQAEZzxmIfWw1pzY0uRfDc/edit?usp=sharing

First Sprint Planning: https://docs.google.com/document/d/1drFdIJE-qsreIDDrfxh0xSr8VGIGRehWNgD4F7WlL4E/edit?usp=sharing

Pre Game Information: https://docs.google.com/document/d/1MurzT4Rio6Ix7LleW22G8R7NBld_ew52qbtzxf0tPTI/edit?usp=sharing

Product Backlog: https://docs.google.com/document/d/1X5jcUJFpCfGCOzySuhNFhbbv16e7ubF2Eh1V4qnJU0E/edit?usp=sharing

First Sprint Documentation: https://drive.google.com/drive/folders/1CUyC1R9dUrK2xHVnGsxveCHhiI0JrF-9?usp=sharing

Second Sprint Documentation: https://drive.google.com/drive/folders/1mUU4qeHeGf9d1yeJviB0Fw_5TrP1Fzyu

Third Sprint Documentation: https://drive.google.com/drive/folders/1FV3GQghaCCcwshvxR_I1S6GZrOf95gZU?usp=sharing

