# Find the Occurrence of First Almost Equal Substring

| Field | Value |
|-------|-------|
| **Platform** | LeetCode |
| **Difficulty** | Hard |
| **Language** | java |
| **Solved On** | September 2, 2026 |
| **Tags** | String, String Matching, Knuth–Morris–Pratt Algorithm |
| **Link** | [View Problem](https://leetcode.com/problems/find-the-occurrence-of-first-almost-equal-substring/) |
| **Runtime** | 71 ms |
| **Memory** | 50.7 MB |

## Problem Description

<p>You are given two strings <code>s</code> and <code>pattern</code>.</p>

<p>A string <code>x</code> is called <strong>almost equal</strong> to <code>y</code> if you can change <strong>at most</strong> one character in <code>x</code> to make it <em>identical</em> to <code>y</code>.</p>

<p>Return the <strong>smallest</strong> <em>starting index</em> of a <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_t_" data-state="closed" class="" fdprocessedid="00527">substring</button></span> in <code>s</code> that is <strong>almost equal</strong> to <code>pattern</code>. If no such index exists, return <code>-1</code>.</p>
A <strong>substring</strong> is a contiguous <b>non-empty</b> sequence of characters within a string.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abcdefg", pattern = "bcdffg"</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>

<p><strong>Explanation:</strong></p>

<p>The substring <code>s[1..6] == "bcdefg"</code> can be converted to <code>"bcdffg"</code> by changing <code>s[4]</code> to <code>"f"</code>.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "ababbababa", pattern = "bacaba"</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The substring <code>s[4..9] == "bababa"</code> can be converted to <code>"bacaba"</code> by changing <code>s[6]</code> to <code>"c"</code>.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "abcd", pattern = "dba"</span></p>

<p><strong>Output:</strong> <span class="example-io">-1</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "dde", pattern = "d"</span></p>

<p><strong>Output:</strong> <span class="example-io">0</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= pattern.length &lt; s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> and <code>pattern</code> consist only of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:</strong> Could you solve the problem if <strong>at most</strong> <code>k</code> <strong>consecutive</strong> characters can be changed?

##  Top Community Optimal Approach

<details>
<summary>Click to expand</summary>

**Title**: [Java/C++/Python] Z-function
**Author**: [@lee215](https://leetcode.com/lee215/)
**Upvotes**: 25 👍
**Link**: [View Original Post](https://leetcode.com/problems/find-the-occurrence-of-first-almost-equal-substring/solutions/5844897/)

---

# **Intuition**
You need a template for z-function.
<br>

# **Explanation**
For every substring of `s`  having same length as pattern,
check it\'s longest prefix same as pattern prefix,
check it\'s longest suffix same as pattern suffix,
if `prefix + 1 + suffix >= m`, then it\'s matched,
return the current index `i`
<br>

# **Complexity**
Time `O(m + n)`
Space `O(m + n)`
<br>

**Java**
```java
    public int minStartingIndex(String s, String pattern) {
        int n = s.length(), m = pattern.length();
        int[] z1 = z_function(pattern + s);
        int[] z2 = z_function(new StringBuilder(s + pattern).reverse().toString());
        for (int i = 0; i <= n - m; ++i)
            if (z1[m + i] + 1 + z2[n - i] >= m)
                return i;
        return -1;
    }
```

**C++**
```cpp
    int minStartingIndex(string s, string pattern) {
        int n = s.size(), m = pattern.size();
        string pattern2(pattern.rbegin(), pattern.rend());
        string s2(s.rbegin(), s.rend());
        vector<int> z1 = z_function(pattern + s);
        vector<int> z2 = z_function(pattern2 + s2);
        for (int i = 0; i <= n - m; ++i)
            if (z1[m + i] + 1 + z2[n - i] >= m)
                return i;
        return -1;
    }
```

**Python**
```py
    def minStartingIndex(self, s: str, pattern: str) -> int:
        n, m = len(s), len(pattern)
        z1 = z_function(pattern + s)
        z2 = z_function(pattern[::-1] + s[::-1])
        for i in range(n - m + 1):
            if z1[m + i] + 1 + z2[n - i] >= m:
                return i
        return -1
```

Upvote this post and save the template from wiki:
**Java**
```java
    private int[] z_function(String s) {
        int n = s.length(), l = 0, r = 0;
        int[] z = new int[n];
        for (int i = 1; i < n; ++i) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
```

**C++**
```cpp
        auto z_function = [](const string& s) -> vector<int> {
            int n = s.size(), l = 0, r = 0;
            vector<int> z(n, 0);
            for (int i = 1; i < n; ++i) {
                if (i <= r) {
                    z[i] = min(r - i + 1, z[i - l]);
                }
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                    ++z[i];
                }
                if (i + z[i] - 1 > r) {
                    l = i;
                    r = i + z[i] - 1;
                }
            }
            return z;
        };
```

**Python**
```py
    def z_function(s):
        n = len(s)
        z = [0] * n
        l, r = 0, 0
        for i in range(1, n):
            if i <= r:
                z[i] = min(r - i + 1, z[i - l])
            while i + z[i] < n and s[z[i]] == s[i + z[i]]:
                z[i] += 1
            if i + z[i] - 1 > r:
                l, r = i, i + z[i] - 1
        return z
```


</details>
