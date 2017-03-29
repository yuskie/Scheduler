from collections import defaultdict


def main():
    file = open("fall_match_making.csv", "r")
    result = open("fall_student_list.csv", "w")
    line_count = 1
    companies = []
    company_student_result = defaultdict(list)
    start = 0
    for line in file:
        if line_count == 17:
            start = len(companies)
        if line_count == 1 or line_count == 17:
            company_array = line.split(",")
            company_array.pop(0)
            for company in company_array:
                companies.append(company)
        else:
            student_array = line.split(",")
            student_array.pop(0)
            for x in range(0,len(student_array)-1):
                clean_string = student_array[x].replace('-', ' ').rstrip().lstrip()
                if line_count <17:
                    student_comp = companies[x]
                else:
                    student_comp = companies[start+x]
                company_student_result[student_comp].append(clean_string)
        line_count += 1
    student_companies = defaultdict(list)
    for key in company_student_result:
        if key != ' ' and key:
            for student in company_student_result[key]:
                student_companies[student].append(key)
    for key in student_companies:
        if key != '' and key and "(" not in key:
            result.write(key + "|")
            for company in student_companies[key]:
                if company and company != ' ':
                    result.write(company + "|")
            result.write("\n")
    result.close()
    file.close()


if __name__ == "__main__":
    main()