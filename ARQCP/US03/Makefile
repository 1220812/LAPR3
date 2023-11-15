exUS03: main.o asm.o
	gcc -g main.o asm.o -o exUS03

main.o: main.c
	gcc -g -Wall -c main.c -o main.o

asm.o: asm.s
	gcc -g -Wall -c asm.s -o asm.o

clean:
	rm -f *.o exUS03

run: exUS03
	./exUS03

debug: exUS03
	gdb -tui ./exUS03
