#Makefile for ck001
MODULE=ck001
FILE=ck001
CC=gfortran

$(MODULE).exe: $(FILE).o
	$(CC) $(OPTIONS) -C -o$(MODULE).exe $(FILE).o
	@echo '$(MODULE) build complete'

$(FILE).o: $(FILE).f
	$(CC) $(OPTIONS) -C -c $(FILE).f

clean:
	rm -f *.o
	rm -f *.s
	rm -f *.exe
