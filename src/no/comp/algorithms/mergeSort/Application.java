package no.comp.algorithms.mergeSort;

class Application {
	public static void main(String[] args) {
	 int[] array = {3, 10, 1, 7, 9, 10, 11, 199, 4, 15, 2, 15, 362};
	 
	 int[] resultArray = new Application().mergeSort(array);
	 
	 for (int i: resultArray) {
		 System.out.print(i + " ");
	 }
	}
	
	public int[] mergeSort(int[] array) {
		/* Проверяем на null. */
		if (array == null) {
			return null;
		}
		
		/* Проверяем на размер. */
		if (array.length < 2) {
			return array;
		}
		
		/* Создаем два массива, сумма элементов которых будет
		 * равна кол-ву жлементов в исходном массиве. */
		int[] partA = new int[array.length / 2];
		int[] partB = new int[array.length - partA.length];
		
		/* Копируем левую часть от начала до середины. */
		System.arraycopy(array, 0, partA, 0, partA.length);
		
		/* Копируем правую чатсь от серидины до конца массива. */
		System.arraycopy(array, partA.length, partB, 0, partB.length);
		
		/* Рекурсивно вызываем метод mergeSort. Он будет крутиться
		 * пока в метод не придет массив размерностью в 1 элемент. */
		partA = mergeSort(partA);
		partB = mergeSort(partB);

		/* Возвращаем результат слияния двух массивов. */
		return mergeArray(partA, partB);
	}
	
	public int[] mergeArray(int[] partA, int[] partB) {
		/* Позиции индексов проверяемых элементов. */
		int aPos = 0, bPos = 0;
		
		/* Создаем результирующий массив размерностью равной
		 * сумме элементов входных массивов. */
		int[] resultArray = new int[partA.length + partB.length];
		
		for (int i = 0; i < resultArray.length; i++) {
			/* Проверяем если ли свободные элементы в массиве a.
			 * Если нет - берем свободный элемент из массива b.
			 * Увеличиваем "курсор" массива b на единицу. */
			if (aPos == partA.length) {
				resultArray[i] = partB[bPos];
				bPos++;
			/* Проверяем есть ли свободные элементы в массиве b.
			 * Если нет - берем элемент из массива a.
			 * Увеличиваем "курсор" массива b на единицу. */
			} else if (bPos == partB.length) {
				resultArray[i] = partA[aPos];
				aPos++;
			/* Проверяем, если элемент из массива a меньше элемента
			 * из массива b, то в результирующий массив попадает
			 * элемент из массива a. */
			} else if (partA[aPos] < partB[bPos]) {
				resultArray[i] = partA[aPos];
				aPos++;
			/* Во всех остальных случаях в результирующий массив
			 * попадет элемент из массива b. */
			} else {
				resultArray[i] = partB[bPos];
				bPos++;
			}
		}
		
		return resultArray;
	}
	
}
