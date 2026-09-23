# Move Zeroes

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 23, 2026 |
| **Tags** | Array, Two Pointers |
| **Link** | [View Problem](https://leetcode.com/problems/move-zeroes/) |
| **Runtime** | 2 ms |
| **Memory** | 47.8 MB |

## Problem Description

<p>Given an integer array <code>nums</code>, move all <code>0</code>'s to the end of it while maintaining the relative order of the non-zero elements.</p>

<p><strong>Note</strong> that you must do this in-place without making a copy of the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [0,1,0,3,12]
<strong>Output:</strong> [1,3,12,0,0]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [0]
<strong>Output:</strong> [0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Could you minimize the total number of operations done?

##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Simple O(N) Java Solution Using Insert Index
**Author**: [@Kurteck](https://leetcode.com/Kurteck/)
**Upvotes**: 1118 👍
**Link**: [View Original Post](https://leetcode.com/problems/move-zeroes/solutions/72011/)

---

 
    // Shift non-zero values as far forward as possible
    // Fill remaining space with zeros

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;        

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }        

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

</details>
