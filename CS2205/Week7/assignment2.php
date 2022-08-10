<?php
    $age = $argv[1]; //give your age as an command line argument. The first element of array is the php file itself, so assign the second element as an input.
    if ($age < 19){
        echo "Your age is $age, which does not meet the criteria.";
    }else{
        echo "Okay, you are eligible to vote!";
    }
?>