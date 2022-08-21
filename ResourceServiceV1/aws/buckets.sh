set -x
awslocal s3api create-bucket --bucket stagingstorage
awslocal s3api create-bucket --bucket permanentstorage
awslocal s3api create-bucket --bucket fallbackstorage
set +x