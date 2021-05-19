make

EXECBASE=ck001
EXECUTABLE=$PWD/$EXECBASE.exe
rm -f fort.*

ln -s input/llh.bin fort.9
ln -s ck001-out.txt fort.10
ln -s ck001-out.bin fort.11

echo $EXECUTABLE
$EXECUTABLE < input/input.dat #> output.dat

rm fort.* *.exe *.o
