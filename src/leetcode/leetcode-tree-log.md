# leetcode刷题日志 -- 树

---

begin: 2019-8-28

## 树

#### [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/)

- **题目描述**

- 给定一个二叉树，返回它的 前序 遍历。

   示例:

  输入: [1,null,2,3]  
     1
      \
       2
      /
     3 

  输出: [1,2,3]

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/BinaryPreorderTraversal.java

#### [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/)

- **题目描述**

- 给定一个二叉树，返回它的中序 遍历。

  示例:

  输入: [1,null,2,3]
     1
      \
       2
      /
     3

  输出: [1,3,2]

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/InorderTraversal.java

#### [145. 二叉树的后序遍历](https://leetcode-cn.com/problems/binary-tree-postorder-traversal/)

- **题目描述**

- 给定一个二叉树，返回它的 后序 遍历。

  示例:

  输入: [1,null,2,3]  
     1
      \
       2
      /
     3 

  输出: [3,2,1]

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/BinaryTreePostorderTraversal.java

#### [101. 对称二叉树](https://leetcode-cn.com/problems/symmetric-tree/)

- **题目描述**

- 给定一个二叉树，检查它是否是镜像对称的。

  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

      1
     / \
    2   2
   / \ / \
  3  4 4  3
  但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

      1
     / \
    2   2
     \   \
     3    3
  说明:

  如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/IsSymmetric.java

#### [102. 二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

- **题目描述**

- 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

  例如:
  给定二叉树: [3,9,20,null,null,15,7],

      3
     / \
    9  20
      /  \
     15   7
  返回其层次遍历结果：

  [
    [3],
    [9,20],
    [15,7]
  ]

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/levelOrder.java

#### [100. 相同的树](https://leetcode-cn.com/problems/same-tree/)

- **题目描述**

- 给定两个二叉树，编写一个函数来检验它们是否相同。

  如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

  示例 1:

  输入:       1         1
            / \       / \
           2   3     2   3

          [1,2,3],   [1,2,3]

  输出: true
  示例 2:

  输入:      1          1
            /           \
           2             2

          [1,2],     [1,null,2]

  输出: false
  示例 3:

  输入:       1         1
            / \       / \
           2   1     1   2

          [1,2,1],   [1,1,2]

  输出: false

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/IsSameTree.java

#### [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/)

- **题目描述**

- 给出一个完全二叉树，求出该树的节点个数。

  说明：

  完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

  示例:

  输入: 
      1
     / \
    2   3
   / \  /
  4  5 6

  输出: 6

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/CountNodes.java

#### [111. 二叉树的最小深度](https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/)

- **题目描述**

- 给定一个二叉树，找出其最小深度。

  最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

  说明: 叶子节点是指没有子节点的节点。

  示例:

  给定二叉树 [3,9,20,null,null,15,7],

      3
     / \
    9  20
      /  \
     15   7
  返回它的最小深度  2.

- **题目答案**

- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/MinDepth.java

- **题目描述**
- 
- **题目答案**
- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/

- **题目描述**
- 
- **题目答案**
- https://github.com/xjk971020/Algorithm/blob/master/src/leetcode/