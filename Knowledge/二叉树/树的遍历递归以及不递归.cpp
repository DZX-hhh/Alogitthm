typedef struct TreeNode {
	int val;
	struct TreeNode* left, * right;
}TreeNode, * Tree;

void visit(TreeNode* node) {
	cout << node->val << endl;
}
/* 中序遍历 */
void in_recursion(Tree root) {
	if (root != NULL) {
		in_recursion(root->left);
		cout << root->val << endl;
		in_recursion(root->right);
	}
}
/*
	思路
	1.扫描当前节点的左孩子,并入栈----直到左孩子为空
	2.栈顶元素出栈
	3.检查出栈元素
		3.1该节点有右孩子,右孩子入栈并重复 1
		3.2该节点无右孩子,重复2
*/
void in_without_recursion(Tree root) {
	stack<TreeNode*> S;
	TreeNode* curr = root;//遍历指针
	while (curr != NULL || !S.empty()) {
		if (curr != NULL) {//1
			S.push(curr);
			curr = curr->left;
		} else {
			curr = S.top();//2.取出栈顶元素
			visit(curr);//访问
			curr = curr->right;//转向右子树
		}
	}
}

/* 先序遍历 */
void pre_recursion(Tree root) {
	if (root != NULL) {
		cout << root->val << endl;
		pre_recursion(root->left);
		pre_recursion(root->right);
	}
}
/*
	思路:和中序类似,,只是访问节点的顺序换了前面
	1.访问当前节点,并入栈
	2.往左子树扫描,重复"1",直到左子树为空
	3.栈顶元素出栈
	4.检查出栈元素
		4.1出栈元素有右孩子,重复"1"
		4.2出栈元素无右孩子,重复"3"
*/
void pre_without_recursion(Tree root) {
	stack<TreeNode*> S;
	TreeNode* curr = root;
	while (curr != NULL || !S.empty()) {
		if (curr != NULL) {
			visit(curr);//访问
			S.push(curr);//1
			curr = curr->left;//2.转向左子树
		} else {
			curr = S.top();
			curr = curr->right;//3.转向右子树
		}
	}
}

void post_recursion(Tree root) {
	if (root != NULL) {
		post_recursion(root->left);
		post_recursion(root->right);
		visit(root);
	}
}
/*
	思路:确保左右子树都已经遍历完成才开始,并且左孩子在右孩子前访问根节点
	1.根节点入栈
	2.不断搜索左子树,重复1..直到为空
	3.此时不能出栈,需要继续搜索右子树
	4.如果栈顶元素被访问,必然是
		4.1右子树为空
		4.2右子树刚被访问完
*/
void post_without_recursion(Tree root) {
	stack<TreeNode*> S;
	TreeNode* curr = root, * prev = NULL;
	while (curr != NULL || !S.empty()) {
		if (curr != NULL) {
			S.push(curr);
			curr = curr->left;
		} else {
			curr = S.top();//取出父节点
			if (curr->right != NULL && curr->right != prev) {//右子树不为空,并且未访问过
				curr = curr->right;//转向右节点
			} else {
				curr = S.top();
				S.pop();
				visit(curr);
				prev = curr;//记录访问过的节点
				curr = NULL;//每次出栈之后,,相当于左右根一整棵树都已经访问过了,,需要置为NULL
			}
		}
	}
}
/* 层序遍历 */
void level(Tree root) {
	stack<TreeNode*> S;
	S.push(root);
	while (!S.empty()) {
		TreeNode* curr = S.top();
		S.pop();
		visit(curr);
		if (curr->left != NULL) {
			S.push(curr->left);
		}
		if (curr->right != NULL) {
			S.push(curr->right);
		}
	}
}