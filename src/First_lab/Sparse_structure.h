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
