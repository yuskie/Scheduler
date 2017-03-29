from collections import defaultdict


def main():
    file = open("fall_match_making.csv", "r")
    result = open("fall_company_list.csv", "w")
    file_lines = []
    line_count = 0
    days = {1: defaultdict(list), 2: defaultdict(list)}
    current_key = 1
    company = []
    slot_counter = 1
    for line in file:
        if not line.startswith(','):
            file_lines.append(line)
            line_array = line.split(",")
            line_array.pop(0)
            if line_count == 0 or line_count == 13:
                company = []
                for comp in line_array:
                    company.append(comp)
            else:
                for x in range(0, (len(line_array)-1)):
                    if line_array[x].rstrip().lstrip() != ' ' and line_array[x]:
                        comp = company[x]
                        days[current_key]["Slot "+str(slot_counter)].append(comp)
                slot_counter += 1
            line_count += 1
        if line_count == 13:
            current_key = 2
            slot_counter = 1
    for day in days:
        result.write("Day:" + str(day) + "\n")
        for slot in days[day]:
            result.write(slot + ":")
            for comp in days[day][slot]:
                result.write(comp+"|")
            result.write("\n")
    result.close()
    file.close()


if __name__ == "__main__":
    main()