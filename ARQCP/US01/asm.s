.section .data

.section .text
	.global extract_token # defines 'exctract_token' as global
	# parameters:
	# char* input in rdi
	# char* token in rsi
	# int* output in rdx
	
extract_token:

	 # prologue
	 pushq %rbp
	 movq %rsp, %rbp
	
	 movq %rsi, %r8 # place the value in rsi (the char pointed by token) in r8
	 
counter:
	
	xor %rcx, %rcx # clean the rcx register
	xor %rax, %rax # clean the rax register 
	movb (%rdi), %cl # place the value in rdi (the char pointed by input) in cl
	
	movl $0, %eax # place 0 in eax
	cmp $35, %cl # compares the value pointed by input with the '#' ascii code
	je input_increment # if the condition is matched, jumps to 'input_increment'
	jmp next # jumps inconditionally to 'next'

input_increment:

	incq %rdi # makes *input point to the next char

compare_loop:

	movzbq (%rsi), %r10 # place the char pointed by *token in r10
	cmp $0, %r10 # verifies if the char pointed by *token is a null terminator
	je match # jumps to 'match' if the condition is matched
	
	movzbq (%rdi), %r11 # place the char pointed by *input in r11
	cmp %r11, %r10 # verifies if the chars pointed by *token and *input are equal
	jne no_match # if the condition isn´t matched, jumps to 'no_match'
	
	incq %rsi # makes *token point to the next char
	incq %rdi # makes *input point to the next char
	jmp compare_loop # jumps inconditionally to 'compare_loop'
	
match:

	jmp get_value # jumps  inconditionally to 'get_value'
	
no_match:
	
	movq $0, %rax # place 0 in rax
	movq %r8, %rsi # copies the value in r8 to rsi, *token now points to the element in r8
	jmp next # jumps inconditionally to 'next'
	
next:
	
	incq %rdi # makes *input point to the next char
	jmp counter # jumps inconditionally to 'counter'
	
get_value:
	
	incq %rdi # makes *input point to the next char
	movq $0, %rax # place 0 in rax
	movq $0, %rcx # place 0 in rcx
	
exctract_number:

	movzbq (%rdi), %rcx # copies the char pointed by *input to rcx
	cmp $0, %cl # verifies if the char pointed by *input is a null terminator 
	je update_output # if the condition is matched, jumps to 'update_output'
	cmp $46, %cl # verifies if the char pointed by *input is a '.' 
	je increment_input # if the condition is matched, jumps to 'increment_input'
	cmp $35, %cl # verifies if the char pointed by *input is a '#' 
	je update_output # if the condition is matched, jumps to 'update_output'
	
	sub $'0', %cl # converts the char pointed by *input from ASCII code in the correspondent integer value 
	imulq $10, %rax # multiplies the result by 10
	add %rcx, %rax # adds the integer value pointed by *input to the the result (rax)
	
	jmp increment_input # jumps inconditionally to 'increment_input'
	
increment_input:
	
	incq %rdi # makes *input point to the next char
	jmp exctract_number # jumps inconditionally to 'extract_number'
	
update_output:
	
	movq %r8, %rsi # place the value in r8 (the char pointed by token) back in rsi
	popq %rdi # restores the initial value of *input
	movl %eax, (%rdx) # place the final value extracted in *output
	
	#epilogue
	movq %rbp, %rsp
	popq %rbp
	
	ret
