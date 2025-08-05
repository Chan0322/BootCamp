package com.test06.tree;

import java.util.Comparator;

public class BinarySearchTree<K, V> {

	// 노드
	class Node<K,V>{
		private K key;	// 키 값
		private V data;	// 데이터
		private Node<K,V> left;	// 왼쪽 자식 노드
		private Node<K,V> right; // 오른쪽 자식 노드
		
		// 생성자
		Node(K key, V data, Node<K, V> left, Node<K, V> right){
			this.key = key;
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		K getKey() {
			return key;
		}
		
		V getValue() {
			return data;
		}
		
		void print() {
			System.out.println(data);
		}
	}
	
	private Node<K,V> root;
	private Comparator<? super K> comparator = null;	// 키의 대소관계를 판단. K 타입의 조상 클래스만 허용한다.
	
	// 기본 생성자 : 비어있는 트리 생성
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(Comparator<? super K> c) {
		this();
		comparator = c;
	}
	
	// 키값들을 비교
	private int comp(K key1, K key2) {
		return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1, key2);
		
		// key1>key2 -> 양수
		// key1<key2 -> 음수
		// key1==key2 -> 0
	}
	
	// 키값으로 검색
	public V search(K key) {
		Node<K, V> n = root;
		
		while(true) {
			if( n == null ) {
				return null;
			}
			
			int cond = comp(key, n.getKey());	// 검색하려는 key와 n의 key를 비교	
			if(cond == 0) {						// 같으면.. 찾았다
				return n.getValue();
			}else if(cond < 0) {				// 검색하려는 key가 n의 key보다 작으면
				n = n.left;						// 왼쪽 서브트리 검색
			}else {
				n = n.right;
			}
		}
		
	}
	
	// 노드 추가
	// 이진검색트리에서 노드 삽입 할 때, 삽입 후에도 조건을 유지하는 이진검색트리여야 한다.
	public void add(K key, V data) {
		if(root==null) {
			root = new Node<K,V>(key, data, null, null);
		}else {
			addNode(root, key, data);
		}
	}
	
	private void addNode(Node<K,V> node, K key, V data) {
		int cond = comp(key, node.getKey());
		if(cond==0) {
			return;	// 해당 키가 이미 존재하므로 추가하는 작업 종료
		}else if(cond < 0) {	// 추가하려는 key가 작다!
			if(node.left==null) {	// 선택노드의 왼쪽이 비었다!
				node.left = new Node<K, V>(key, data, null, null);
			}else {
				addNode(node.left, key, data);
			}
		}else {
			if(node.right == null) {
				node.right = new Node<K, V>(key, data, null, null);
			}else {
				addNode(node.right, key, data);
			}
		}
	}
	
	// 노드 삭제
	public boolean remove(K key) {
		Node<K,V> p = root;			// 비교 중인 노드
		Node<K,V> parent = null;	// 비교 중인 노드의 부모
		boolean isLeftChild = true;	// p가 parent의 왼쪽 자식인지

		// 삭제할 키를 가지고 노드를 탐색
		// 만약 찾았다! p=>찾은노드 (삭제하려는 노드), parent=>찾은노드의부모
		while(true) {
			if(p==null) {
				return false;
			}
			int cond = comp(key, p.getKey());	// 삭제하려는 key와 비교중인 node의 key를 비교
			if(cond==0) {
				break;
			}else {
				parent = p;
				if(cond<0) {
					isLeftChild = true;
					p = p.left;
				}else {
					isLeftChild = false;
					p = p.right;
				}
			}
		}
		
		//삭제
		// 만약 찾았다! p=>찾은노드 (삭제하려는 노드), parent=>찾은노드의부모
		if(p.left == null) {	//p의 왼쪽 자식이 없을 때
			if(p==root) {
				root = p.right;
			}else if(isLeftChild) {
				parent.left = p.right;
			}else {
				parent.right = p.right;
			}
			
		}else if(p.right == null) {	// p의 오른쪽 자식이 없을 때
			if(p==root) {
				root = p.left;
			}else if(isLeftChild) {
				parent.left = p.left;
			}else {
				parent.right = p.left;
			}
		}else {
			// 자식 노드가 2개일 때 (왼쪽 오른쪽 다 자식이 있을 때)
			parent = p;
			Node<K, V> left = p.left;	// 서브트리 중 최대 노드
			isLeftChild = true;
			
			while(left.right != null) {
				parent = left;
				left = left.right;
				isLeftChild = false;
			}
			// left => 왼쪽 서브트리 중 가장 큰 노드
			// parent => left의 부모
			// isLeftChild => 가장 큰 노드(left)가 parent의 왼쪽인지 아닌지 판단.
			
			// 왼쪽 서브트리 중 가장 큰 노드를 삭제할 노드(p)에 덮어 씌운다.
			p.key = left.key;
			p.data = left.data;
			
			if(isLeftChild) {	// 가장 큰 노드가 부모의 왼쪽일때
				parent.left = left.left;
			}else {
				parent.right = left.left;
			}
		}
		
		return true;
	}
	
	// 출력
	public void print() {
		printSubTree(root);
	}
	private void printSubTree(Node node) {
		if(node != null) {
			printSubTree(node.left);
			System.out.println(node.key + " " + node.data);
			printSubTree(node.right);
		}
	}
}
