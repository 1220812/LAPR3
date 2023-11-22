.section .text
	.global mediana

mediana:

	movl $0, %r8d			# new counter in r8d
	movl %esi, %eax			# num stored in eax
	movl $2, %ecx
	cdq
	idivl %ecx 				# divide num by 2 and store num/2 in eax

	pushq %r8
	pushq %rax
	pushq %rsi
	call sort_array
	popq %rsi
	popq %rax
	popq %r8

loop:

	cmpl %r8d, %eax
	je end_loop

	addq $4, %rdi			# move to the next element in the array
	incl %r8d				# increment counter
	jmp loop

end_loop:

	movl (%rdi), %eax

end:

	ret