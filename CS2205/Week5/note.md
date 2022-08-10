Javascript memo
- let can be used to create value. default value is "undefined".
- helper functions : functions called inside functions.
- function expression : a way to define a function inside of expression. And the name of function is usually omitted. So it is called anonymous functions.
- arrow functions : use "=>" to ommit a decalation of functions
- concise body : the most simple form of writing functions
- ES6 : JavaScript ES6, it means that that version of JavaScript is following the specifications in the sixth edition of ECMAScript.  ES6 is actually the biggest update made to ECMAScript since the first edition released in 1997.
  - new keywords like let and const to declare variables
  - new function syntax using Arrow functions
  - creation of Classes
  - parameters with default values
  - promises for asynchronous actions,
  - and many more!
- features of ES6 makes it easier to utilize OOP. Also, popular framework such as React uses ES6.
- document.getElementById("xxx").xxx can change elements or properties of HTML and CSS with Javascript. examples are below.
  - innerHTML
  - style.fontSize
  - style.display
- use script tags when writing JS in HTML format. it can be placed anywhere such body or header and so on.
- many ways to output
  - Writing into an HTML element, using innerHTML.
  - Writing into the HTML output using document.write().
    - Using document.write() after an HTML document is loaded, will delete all existing HTML
  - Writing into an alert box, using window.alert().
  - Writing into the browser console, using console.log().
- When separated by semicolons, multiple statements on one line are allowed
- For best readability, programmers often like to avoid code lines longer than 80 characters.
- here is how to use a object in JS below

<pre><code>
const person = {
  firstName: "John",
  lastName : "Doe",
  id       : 5566,
  fullName : function() {
    return this.firstName + " " + this.lastName;
  }
};
</code></pre>

- "this" is the keyword that represents different meanings depending on contexts
  - In an object method, this refers to the object.
  - Alone, this refers to the global object.
  - In a function, this refers to the global object.
  - In a function, in strict mode, this is undefined.
  - In an event, this refers to the element that received the event.
  - Methods like call(), apply(), and bind() can refer this to any object.