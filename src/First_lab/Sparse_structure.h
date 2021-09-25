#pragma once
#include <iostream>
#include <cassert>

template <typename T>
class Node {
public:
	T data;
	Node* next;
	int pos;
	Node(T data, int pos) {
		this->data = data;
		this->pos = pos;
		this->next = nullptr;
	}
};

template<typename T>
class Sparse_list
{
public:
	Sparse_list() {
		this->root = nullptr;
		this->n = 0;
	}
	Sparse_list(int n) :Sparse_list() {
		this->n = n;
	}
	~Sparse_list() {
		Node<T>* current = this->root;
		while (current) {
			Node<T>* node_for_deleting = current;
			current = current->next;
			delete node_for_deleting;
		}
	}
private:
	Node<T>* root;
	int n;
};