.section .data
.global vec
.global num

.section .text
.global sort_array              # void sort_array(int* vec, int num);

sort_array:
    movl $0, %r8d               # start a counter at 0

firstLoop:
    cmp $0, %esi                # if the number of elements is 0
    je end                      # jump to end

    decl %esi                   # num--
    movl %esi, %r8d             # move esi to the counter
    jmp secondLoop              # jump to secondLoop

secondLoop:
    cmp $0, %r8d                # compare r8d to 0
    je altEnd                   # if r8d is 0, jump to altEnd

    movl (%rdi), %ecx           # move the value at rdi to ecx
    movl %ecx, %r9d             # move ecx to r9d

    addq $4, %rdi               # add 4 to rdi
    movl (%rdi), %ecx           # move the value at rdi to ecx
    movl %ecx, %r10d            # move ecx to r10d

    cmp %r9d, %r10d             # compare r9d to r10d
    jl swap                     # if r9d > r10d, jump to swap

    decl %r8d                   # r8d--
    jmp secondLoop              # jump to secondLoop

swap:
    subq $4, %rdi               # subtract 4 to rdi
    movl %r10d, (%rdi)          # move r10d to the value at rdi

    addq $4, %rdi               # add 4 to rdi
    movl %r9d, (%rdi)           # move r9d to the value at rdi

    decl %r8d                   # r9d--
    jmp secondLoop              # jump to secondLoop

reset:
    cmp $0, %r8d                # compare r8d to 0
    je firstLoop                # if r8d is 0, jump to firstLoop

    subq $4, %rdi               # subtract 4 from rdi
    decl %r8d                   # r8d--
    jmp reset                   # jump to reset loop

altEnd:
    movl %esi, %r8d             # move esi to the counter
    jmp reset                   # jump to reset

end:
	ret
