# Max Consecutive Ones

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Easy |
| **Language** | java |
| **Solved On** | September 24, 2026 |
| **Tags** | Array |
| **Link** | [View Problem](https://leetcode.com/problems/max-consecutive-ones/) |
| **Runtime** | 2 ms |
| **Memory** | 52.8 MB |

## Problem Description

<p>Given a binary array <code>nums</code>, return <em>the maximum number of consecutive </em><code>1</code><em>'s in the array</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,1,0,1,1,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,0,1,1,0,1]
<strong>Output:</strong> 2
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code> is either <code>0</code> or <code>1</code>.</li>
</ul>


##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: Java | TC: O(N) | SC: O(1) | Easy & Concise solution
**Author**: [@NarutoBaryonMode](https://leetcode.com/NarutoBaryonMode/)
**Upvotes**: 28 👍
**Link**: [View Original Post](https://leetcode.com/problems/max-consecutive-ones/solutions/1507990/)

---

```java
/**
 * Maintain current count and maximum count so far.
 *
 * Time Complexity: O(N)
 *
 * Space Complexity: O(1)
 *
 * N = Length of the input array
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array is null");
        }

        int curCount = 0;
        int maxCount = 0;

        for (int n : nums) {
            if (n == 1) {
                curCount++;
                maxCount = Math.max(maxCount, curCount);
            } else {
                curCount = 0;
            }
        }

        return maxCount;
    }
}
```

---

Solutions to other parts of Max Consecutive Ones question on LeetCode:
- [487. Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/discuss/1508045/Java-or-TC:-O(N)-or-SC:-O(1)-or-Four-solutions-with-Follow-up-handled)
- [1004. Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/discuss/1508044/Java-or-TC:-O(N)-or-SC:-O(1)-or-One-Pass-Optimized-Sliding-Window)


</details>
