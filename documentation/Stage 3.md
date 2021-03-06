## Stage 3/6 Decrypted!

### Description

In this stage, you need to support decryption in your program. The decryption is simply the inverse of encryption,
following the same steps but reversing the order in which the keys are applied.

Write a program that reads three lines from the standard input: a target operation (**enc** for encryption, **dec** for
decryption), a message or a cyphertext, and a key to encrypt/decrypt messages. All non-letter characters should be
encrypted as well as regular letters. We recommend you to get an integer representation of each character (according to
the Unicode table) to shift it.

Decompose your program using methods to make it easy to understand and edit later. One method should encrypt a message
and another one should decrypt it according to a key.

**Encryption input example**
> enc  
> Welcome to hyperskill!  
> 5

**Encryption output example**
> \jqhtrj%yt%m~ujwxpnqq&

**Decryption input example**
> dec  
> \jqhtrj%yt%m~ujwxpnqq&  
> 5

**Decryption output example**
> Welcome to hyperskill!
