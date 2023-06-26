def MaxHeapify (A,i):
    l = i+1
    r = i+2

    largest = i 

    if (l<len(A)): 
        if(A[l]>A[i]):
            largest = l
            
    if (r<len(A)):
        if(A[r]>A[largest]):
            largest = r 
    if i != largest:
        flag=A[i]
        A[i]=A[largest]
        A[largest]=flag

        MaxHeapify (A, largest)

def HeapBottomUp(A):
    #A =[]
    #A. = B.length
    length = int(len(A)/2)

    for i in range(length-1, -1, -1):
        MaxHeapify(A,i)
    
    print(A)

n = int(input())
A = []
for i in range(n):
    A.append(int(input()))
    
HeapBottomUp(A)