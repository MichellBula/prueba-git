class Node:
    def __init__(self, data):
        self.data = data  # Almacena el dato del nodo
        self.next = None   # Inicializa el puntero al siguiente nodo como None

class LinkedList:
    def __init__(self):
        self.head = None  # Inicializa la cabeza de la lista como None (lista vacía)

    def insert_at_end(self, data):
        new_node = Node(data)  # Crea un nuevo nodo con el dato proporcionado
        if not self.head:  # Si la lista está vacía
            self.head = new_node  # El nuevo nodo se convierte en la cabeza
            return
        last_node = self.head  # Inicia desde la cabeza
        while last_node.next:  # Avanza hasta el último nodo
            last_node = last_node.next
        last_node.next = new_node  # Inserta el nuevo nodo al final de la lista

    def move_negatives_to_front(self):
        if not self.head:  # Si la lista está vacía, no hay nada que hacer
            return
        
        # Inicializa variables para almacenar nodos de diferentes categorías
        neg_head = None
        neg_tail = None
        pos_head = None
        pos_tail = None
        zero_head = None
        zero_tail = None

        current = self.head  # Comienza desde la cabeza de la lista
        while current:  # Itera sobre todos los nodos de la lista
            next_node = current.next  # Guarda el siguiente nodo antes de modificar la lista
            if current.data < 0:  # Si el nodo actual tiene un valor negativo
                if not neg_head:  # Si la lista de números negativos está vacía
                    neg_head = current  # El nodo actual se convierte en la cabeza de la lista de negativos
                    neg_tail = current  # Y también en el último nodo de esa lista
                else:  # Si ya hay nodos en la lista de negativos
                    neg_tail.next = current  # Añade el nodo actual al final de la lista
                    neg_tail = current  # Actualiza el nodo final de la lista de negativos
            elif current.data == 0:  # Si el nodo actual tiene un valor de cero
                if not zero_head:  # Si la lista de ceros está vacía
                    zero_head = current  # El nodo actual se convierte en la cabeza de la lista de ceros
                    zero_tail = current  # Y también en el último nodo de esa lista
                else:  # Si ya hay nodos en la lista de ceros
                    zero_tail.next = current  # Añade el nodo actual al final de la lista
                    zero_tail = current  # Actualiza el nodo final de la lista de ceros
            else:  # Si el nodo actual tiene un valor positivo
                if not pos_head:  # Si la lista de números positivos está vacía
                    pos_head = current  # El nodo actual se convierte en la cabeza de la lista de positivos
                    pos_tail = current  # Y también en el último nodo de esa lista
                else:  # Si ya hay nodos en la lista de positivos
                    pos_tail.next = current  # Añade el nodo actual al final de la lista
                    pos_tail = current  # Actualiza el nodo final de la lista de positivos
            current = next_node  # Avanza al siguiente nodo

        # Concatena todas las listas de nodos
        if neg_tail:  # Si hay nodos negativos en la lista
            self.head = neg_head  # La cabeza de la lista se convierte en la cabeza de la lista de negativos
            if zero_tail:  # Si hay nodos de ceros en la lista
                neg_tail.next = zero_head  # Concatena la lista de negativos con la de ceros
                zero_tail.next = pos_head  # Concatena la lista de ceros con la de positivos
            else:  # Si no hay nodos de ceros en la lista
                neg_tail.next = pos_head  # Concatena la lista de negativos con la de positivos
        elif zero_tail:  # Si no hay nodos negativos pero hay nodos de ceros en la lista
            self.head = zero_head  # La cabeza de la lista se convierte en la cabeza de la lista de ceros
            zero_tail.next = pos_head  # Concatena la lista de ceros con la de positivos
        else:  # Si no hay nodos negativos ni de ceros en la lista
            self.head = pos_head  # La cabeza de la lista se convierte en la cabeza de la lista de positivos

    def display(self):
        current = self.head  # Comienza desde la cabeza de la lista
        while current:  # Itera sobre todos los nodos de la lista
            print(current.data, end=" -> ")  # Imprime el valor del nodo actual
            current = current.next  # Avanza al siguiente nodo
        print("None")  # Imprime "None" al final de la lista

# Ejemplo de uso
if __name__ == "__main__":
    ll = LinkedList()  # Crea una instancia de LinkedList
    ll.insert_at_end(10)  # Inserta nodos en la lista
    ll.insert_at_end(-4)
    ll.insert_at_end(0)
    ll.insert_at_end(7)
    ll.insert_at_end(-2)
    ll.insert_at_end(0)
    ll.insert_at_end(-9)
    ll.insert_at_end(5)

    print("Lista original:")
    ll.display()  # Muestra la lista original

    ll.move_negatives_to_front()  # Mueve los números negativos al principio, ceros en el medio y positivos al final

    print("\nLista con números negativos al principio, cero en el medio y números positivos al final:")
    ll.display()  # Muestra la lista modificada
