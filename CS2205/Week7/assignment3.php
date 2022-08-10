<?php
   $num = $argv[1]; //give your age as an command line argument. The first element of array is the php file itself, so assign the second element as an input.
   if (is_numeric($num)){
        if ($num == 1){
            echo "Your input is $num, which is not prime.";
            exit;
        }
        for ($i = 2; $i <= $num/2; $i++){
            if ($num % $i == 0)
            echo "Your input is $num, which is not prime.";
            exit;
        }
        echo "Your input is $num, which is prime.";
        exit;
    }else{
        echo "Your input is $num, which is not integer type. Please input a valid value.";
        exit;
    }
?>