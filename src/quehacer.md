Usar comparators.

o1 = root
o2 = nodo a buscar

1. Buscar
    si o1>o2 = ir a la izq(buscar menores)
    si o1==o2 = lo encontramos! print(Se ha encontrado)
    si o1<o2 = ir a la derecha(buscar mayores)

2. Insercion
   si o1>o2 = ir a la izq(buscar menores)
   si o1==o2 = el numero ya esta en la lista. 
   si o1<o2 = ir a la derecha(buscar mayores) 

   si el nodo cumple lo que dice isLeaf() es decir, es un dead end:
        Si o1>o2 = setLeft(o2)
        Si o1<o2 = setRight(o2)

3. Eliminar
   si o1>o2 = ir a la izq(buscar menores)
   si o1==o2 = Se elimina
   si o1<o2 = ir a la derecha(buscar mayores)