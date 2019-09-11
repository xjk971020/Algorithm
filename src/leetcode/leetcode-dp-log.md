# leetcode刷题日志 -- 动态规划

------

begin: 2019-9-3

### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

- **题目描述**

- 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

  示例:

  输入: [-2,1,-3,4,-1,2,1,-5,4],
  输出: 6
  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/MaxSubArray.java

### [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

- **题目描述**

- 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

  例如，给定三角形：

  [
       [2],
      [3,4],
     [6,5,7],
    [4,1,8,3]
  ]
  自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/MinimumTotal.java

### [5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)

- **题目描述**

- 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

  示例 1：

  输入: "babad"
  输出: "bab"
  注意: "aba" 也是一个有效答案。
  示例 2：

  输入: "cbbd"
  输出: "bb"

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/LongestPalindrome.java

###  [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

- **题目描述**

- 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

  说明：每次只能向下或者向右移动一步。

  示例:

  输入:
  [
    [1,3,1],
    [1,5,1],
    [4,2,1]
  ]
  输出: 7

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/MinPathSum.java

### [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

- **题目描述**

- 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

  问总共有多少条不同的路径?

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/UniquePaths.java

### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

- **题目描述**

- 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

  注意：给定 n 是一个正整数。

  示例 1：

  输入： 2
  输出： 2
  解释： 有两种方法可以爬到楼顶。
  1.  1 阶 + 1 阶
  2.  2 阶
  示例 2：

  输入： 3
  输出： 3
  解释： 有三种方法可以爬到楼顶。
  1.  1 阶 + 1 阶 + 1 阶
  2.  1 阶 + 2 阶
  3.  2 阶 + 1 阶

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/ClimbStairs.java

### [139. 单词拆分](https://leetcode-cn.com/problems/word-break/)

- **题目描述**

- 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

  说明：

  拆分时可以重复使用字典中的单词。
  你可以假设字典中没有重复的单词。
  示例 1：

  输入: s = "leetcode", wordDict = ["leet", "code"]
  输出: true
  解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
  示例 2：

  输入: s = "applepenapple", wordDict = ["apple", "pen"]
  输出: true
  解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
       注意你可以重复使用字典中的单词。
  示例 3：

  输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
  输出: false

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/WordBreak.java

### [152. 乘积最大子序列](https://leetcode-cn.com/problems/maximum-product-subarray/)

- **题目描述**

- 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

  示例 1:

  输入: [2,3,-2,4]
  输出: 6
  解释: 子数组 [2,3] 有最大乘积 6。
  示例 2:

  输入: [-2,0,-1]
  输出: 0
  解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/MaxProduct.java

### 

- **题目描述**
- 
- **题目答案**
- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/