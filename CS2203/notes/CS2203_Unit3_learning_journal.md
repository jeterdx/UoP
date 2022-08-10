- Describe what you did (This does not mean that you copy and paste from what you have posted or the assignments you have prepared. You need to describe what you did and how you did it), what you learned, your weekly activities, in what ways are you able to apply the ideas and concepts gained, and finally, describe one important thing that you are thinking about in relation to the activity.
  - What I did in this unit is almost the same as what I did in the last unit; I started from understanding the big image of contents of this unit such as “what is normalization and how it is useful for database system” through reading the introduction of this course. Then, I proceeded to complete a reading and video materials to get more details of those topics. What impressed me was the concept of over-normalization of database and data loss caused by decomposition of database. These two concepts reminded me of the importance of balance to take between the efficiency to operate database and performance of computing resources. Then, I moved onto the non-graded quiz part to check my knowledge I learned from those materials. Then, I challenged the graded quiz. I made a mistake in 3 questions which shows the lack of understanding on the topic. Especially, I did not understand the process of 2NF and BCNF correctly. So, I felt the necessity of reviewing the materials of the last 3 weeks, especially this week. Then, this learning journal has turned out to be an appropriate work for the purpose as the last work of this unit. Before moving to the part of last work, I have one learning this week. Since I did not go through the content of learning journal before graded quiz, I was not familiar with the image of book relations which were both on the graded quiz and learning journal. Based on that, I should have gone through every material before doing the each of them, in order not to miss the valuable information of learning, that is, the order of learning that I should follow. The rest of my work is below.

- Consider a relation named as BOOK that contains data about the books in a library. BOOK relation was initially created with the attributes BookID (an id that library assigns), ISBN, CopyNr (used to differentiate copies of the same book), Title, PublYear, Author, and AuthorBornYear. First determine which normal form (1NF, 2NF, 3NF or BCNF) the above relation is, and why. Then, if necessary, convert the above relation to the highest normal form (BCNF). Write any assumptions that you make.
  - Firstly, Book relation has met the requirement of 1NF since there is not repeated set of data in the attributes of the relation. Every attribute seems to be unique. As for the condition of 2NF, it is not fulfilled. As the dependency information show, while dependency 2 and 3 shows that each group of columns is in the relation of partial functional dependencies, the table is not separated. Therefore, we need to normalize the table into 2 and 3 NF. The result of the two steps of normalization is below. There are no partial functional dependencies anymore. Also, no columns that have functional dependencies on non-primary keys exist anymore. So, this is the result of normalizations. Finally, the status of BCNF has been confirmed. As the table shows, there is no non-key that has functional dependencies on candidate-key. Therefore, this table in the image below has met the requirement of BCNF.