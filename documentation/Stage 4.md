## Stage 4/6 I command you

### Description

Modify the previous program to work with command-line arguments instead of the standard input. The program must parse
three arguments: **-mode**, **-key** and **-data**. The first argument should determine the program’s mode (**enc** for
encryption, **dec** for decryption). The second argument is an integer key to modify the message, and the third argument
is a text or ciphertext to encrypt or decrypt.

All the arguments are guaranteed to be passed to the program. If for some reason it turns out to be wrong:

1. If there is no **-mode**, the program should work in **enc** mode.
2. If there is no **-key**, the program should consider that **key** = 0.
3. If there is no **-data**, the program should assume that the **data** is an empty string.

Keep in mind that the order of the arguments might be different. For example, -mode enc may be at the end, at the
beginning or in the middle of arguments array.

> Note that to pass an argument that contains spaces as a single argument you need to put it in quotes. So "Welcome to hyperskill!" becomes a single Welcome to hyperskill! argument that doesn't contain quotes. You need quotes to pass this argument in the terminal, but you don't need to remove these quotes in the actual code! In the following examples arguments from the terminal perspective are put in quotes.

**Run configuration examples for encryption**
> java Main -mode enc -key 5 -data "Welcome to hyperskill!"

**Encryption output example**
> \jqhtrj%yt%m~ujwxpnqq&

**Run configuration examples for decryption**
> java Main -key 5 -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

**Decryption output example**
> Welcome to hyperskill!
