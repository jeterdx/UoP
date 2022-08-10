1. Why do Boolean functions play a central role in hardware architectures?
　As described in the textbook, the most fundamental component of modern computer is a transistor, which operates an electricity as binary inputs and outputs (Nisan & Schocken, 2005). Boolean function is a concept of abstraction of this physical phenomenon throughout the concept of computer. In addition to this point, many of basic function such as AND, OR, and NOT, are based on this Boolean functions. Therefore, Boolean function that reproduces actual transistors with computer code can be said as a central role in hardware architecture.

2. Describe Composite Gates.
　Composite gates are a way to describe multiple primitive logic gates with one logic gate. One of the most important points of logic gate is just to express the inputs and outputs, not showing a complex internal architecture of the gates. So if we want to know how many inputs are required or what type of inputs generate what type of outputs, it is powerful to use composite gates. Here is the image of composite gates quoted from textbook (Nisan & Schocken, 2005).


3. Describe Multiplexors and Demultiplexors? What is the importance of the use of the selection bit and the data bits?
　Multiplexors are gates that take more than two inputs and produce a single output. On the other hand, demultiplexors are gates that take a single input and generate multiple outputs. In this context, the role of selection bit is very important. As the fundamental role of multiplexor and demultiplexor shows, it is crucial to use only single line as an input or output in each case but accept multiple inputs or outputs from multiple lines. In order to determine which line to use as an input or output, selection bit is used. For instance, when selection bit is 0, one of the two input line, called "a, is used, and when selection bit is 1, the other line, called "b", is used. Then, the bit that used as an output based on the result of selection bit is called data bits.

References:
Nisan, N., & Schocken, S. (2005). The elements of computing systems. MIT Press.