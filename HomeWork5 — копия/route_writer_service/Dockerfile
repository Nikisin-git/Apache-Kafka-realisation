FROM python:3.13.3-slim

WORKDIR /app

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY ./app ./app

#COPY wait-for-it.sh /wait-for-it.sh
#RUN chmod +x /wait-for-it.sh

CMD ["python", "-u", "app/consumer.py"]