package com.vinit.example.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxTeam {
    public static void main(String[] args) {

/*int[] skill={5,1,2,1,4,5};
int teamSize=3;
int maxDiff=2;*/
        int[] skill = { 9, 3, 5, 7, 1};
        int teamSize = 2;
        int maxDiff = 1;
        System.out.println(getMaxTeams(skill, teamSize, maxDiff));
    }

    public static int getMaxTeams(int[] skill, int teamSize, int maxDiff) {

        /*Sort and use sliding windows of teamSize to identify teams
         */
        //final count
        int result = 0;
        //tracks the start of each window of size -> teamSize
        int currindex = 0;

        //Sort the int array
        List<Integer> skills = Arrays.stream(skill).boxed().collect(Collectors.toList());
        Collections.sort(skills, Collections.reverseOrder());
        skill = skills.stream().mapToInt(Integer::intValue).toArray();
     //   Arrays.stream(skill).forEach(System.out::println);

        /* Check windows of size teamSize for eligibility (diff of first element and last element to be <=maxDiff)
         * If current window does not satisfy - move currentindex to currentindex+1 and inspect next window
         * If current windows satisfies - then update result, move currentindex to currentindex + teamSize (skip elements already checked).
         */
        while (currindex + (teamSize - 1) < skill.length) { // Terminating condition - no more windows to check
            if ((skill[currindex] - skill[currindex + teamSize - 1]) <= maxDiff) {
                result += 1;
                currindex = currindex + teamSize;
            } else {
                currindex++;
            }
        }//End of while

        return result;
    }

    // Change this if((skill[currindex] - skill[currindex]+teamSize-1) <= maxDiff){
    //   to if((skill[currindex] - skill[currindex+teamSize-1]) <= maxDiff){

}
