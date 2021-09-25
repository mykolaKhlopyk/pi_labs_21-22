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
	void add(T data, int index) {
		assert(index < this->n, "Incorrect element's index");
		Node<T>* current = this->root;
		if (!this->root)
		{
			this->root = new Node<T>(data, index);
		}
		else if (index < current->pos) {
			this->root = new Node<T>(data, index);
			this->root->next = current;
		}
		else {
			while (current->next) {
				if (current->next->pos == index)
				{
					current->next->data = data;
					return;
				}
				else if (current->next->pos > index) {
					Node<T>* new_node = new Node<T>(data, index);
					new_node->next = current->next;
					current->next = new_node;
					return;
				}
				current = current->next;
			}
			current->next = new  Node<T>(data, index);
		}
	}

	void print() {
		Node<T> *current = this->root;
		for (int i = 0; i < this->n; i++)
		{
			if (current)
			{
				if (current->pos == i)
				{
					std::cout << current->data << "\t";
					current = current->next;
					continue;
				}
			}
			std::cout << 0 << "\t";
		}
		std::cout << "\n";
	}
private:
	Node<T>* root;
	int n;
};